package com.sladkin.vidmeapp.presentation.featured

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.sladkin.vidmeapp.R
import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.presentation.MainActivity
import com.sladkin.vidmeapp.presentation.adapter.EndlessRecyclerViewScrollListener
import com.sladkin.vidmeapp.presentation.adapter.PreCachingLayoutManager
import com.sladkin.vidmeapp.presentation.adapter.VideoRecyclerAdapter
import com.sladkin.vidmeapp.presentation.adapter.VideoViewHolder
import com.sladkin.vidmeapp.presentation.news.NewsPresenter
import javax.inject.Inject

class FeaturedFragment: Fragment(), FeaturedPresenter.FeaturedView {

    @Inject
    lateinit var featuredPresenter: FeaturedPresenter<FeaturedPresenter.FeaturedView>

    @BindView(R.id.recycler)
    lateinit var featuredRv: RecyclerView

    @BindView(R.id.swipe_refresh)
    lateinit var refresh: SwipeRefreshLayout

    @BindView(R.id.progress_bar)
    lateinit var progress: ProgressBar

    var videoList: ArrayList<VideoModel> = ArrayList()
    var adapter: RecyclerView.Adapter<VideoViewHolder>? = null
    var scrollListener: EndlessRecyclerViewScrollListener? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.list_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDagger()
        if (view != null) {
            ButterKnife.bind(this, view)
            setUpRecycler()
        }
        refresh.setOnRefreshListener {
            clearRecycler()
            featuredPresenter.requestVideos(0)
        }
        featuredPresenter.requestVideos(0)
    }

    override fun onVideosLoaded(videoList: List<VideoModel>) {
        refresh.isRefreshing = false
        progress.visibility = View.GONE
        addItemsToRecycler(videoList)
    }

    override fun onError(error: Throwable) {
        refresh.isRefreshing = false
        Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
    }

    fun addItemsToRecycler(list: List<VideoModel>) {
        videoList.addAll(list)
        adapter?.notifyDataSetChanged()
    }

    fun clearRecycler() {
        videoList.clear()
        scrollListener?.resetState()
        adapter?.notifyDataSetChanged()
    }

    fun setUpRecycler() {
        adapter = VideoRecyclerAdapter(context, videoList)
        val layoutManager = PreCachingLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.setExtraLayoutSpace(resources.displayMetrics.density.toInt()*3)

        val dividerItemDecoration = DividerItemDecoration(featuredRv.context,
                layoutManager.orientation)
        featuredRv.addItemDecoration(dividerItemDecoration)

        featuredRv.adapter = adapter
        featuredRv.layoutManager = layoutManager

        scrollListener = object: EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                progress.visibility = View.VISIBLE
                featuredPresenter.requestVideos(totalItemsCount)
            }
        }
        featuredRv.addOnScrollListener(scrollListener)
    }

    fun initDagger() {
        (activity as MainActivity).featuredComponent?.inject(this)
        featuredPresenter.setView(this)
    }
}