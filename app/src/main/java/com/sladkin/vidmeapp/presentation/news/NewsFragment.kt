package com.sladkin.vidmeapp.presentation.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.sladkin.vidmeapp.R
import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.presentation.MainActivity
import com.sladkin.vidmeapp.presentation.adapter.VideoRecyclerAdapter
import com.sladkin.vidmeapp.presentation.adapter.VideoViewHolder
import javax.inject.Inject
import android.support.v7.widget.DividerItemDecoration
import android.widget.Toast


class NewsFragment: Fragment(), NewsPresenter.NewsView{

    @Inject
    lateinit var newsPresenter: NewsPresenter<NewsPresenter.NewsView>

    @BindView(R.id.recycler)
    lateinit var newsRv: RecyclerView

    @BindView(R.id.swipe_refresh)
    lateinit var refresh: SwipeRefreshLayout

    var videoList: ArrayList<VideoModel> = ArrayList()
    var adapter: RecyclerView.Adapter<VideoViewHolder>? = null

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
            newsPresenter.requestNewVideos()
        }
        newsPresenter.requestNewVideos()
    }

    override fun onVideosLoaded(videoList: List<VideoModel>) {
        refresh.isRefreshing = false
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
        adapter?.notifyDataSetChanged()
    }

    fun setUpRecycler() {
        adapter = VideoRecyclerAdapter(context, videoList)
        val layoutManager = LinearLayoutManager(context)

        val dividerItemDecoration = DividerItemDecoration(newsRv.context,
                layoutManager.orientation)
        newsRv.addItemDecoration(dividerItemDecoration)

        newsRv.adapter = adapter
        newsRv.layoutManager = layoutManager
    }

    fun initDagger() {
        (activity as MainActivity).newsComponent?.inject(this)
        newsPresenter.setView(this)
    }

}