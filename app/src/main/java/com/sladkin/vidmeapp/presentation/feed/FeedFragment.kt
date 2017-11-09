package com.sladkin.vidmeapp.presentation.feed

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.sladkin.vidmeapp.R
import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.extensions.getUser
import com.sladkin.vidmeapp.presentation.MainActivity
import com.sladkin.vidmeapp.presentation.adapter.EndlessRecyclerViewScrollListener
import com.sladkin.vidmeapp.presentation.adapter.PreCachingLayoutManager
import com.sladkin.vidmeapp.presentation.adapter.VideoRecyclerAdapter
import com.sladkin.vidmeapp.presentation.adapter.VideoViewHolder
import kotlinx.android.synthetic.main.sign_in_fragment.*
import javax.inject.Inject

class FeedFragment : Fragment(), FeedPresenter.FeedView {

    @Inject
    lateinit var feedPresenter: FeedPresenter<FeedPresenter.FeedView>

    @BindView(R.id.recycler)
    lateinit var newsRv: RecyclerView

    @BindView(R.id.swipe_refresh)
    lateinit var refresh: SwipeRefreshLayout

    @BindView(R.id.progress_bar)
    lateinit var progress: ProgressBar

    @BindView(R.id.list_fragment_linear)
    lateinit var listLinear: LinearLayout

    @BindView(R.id.login_linear)
    lateinit var signInLinear: LinearLayout



    var videoList: ArrayList<VideoModel> = ArrayList()
    var adapter: RecyclerView.Adapter<VideoViewHolder>? = null
    var scrollListener: EndlessRecyclerViewScrollListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.sign_in_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDagger()
        if (view != null) {
            ButterKnife.bind(this, view)
            setUpView()
            setUpRecycler()
        }
    }

    fun setUpView() {
        refresh.setOnRefreshListener {
            clearRecycler()
            feedPresenter.requestVideos(0, context.getUser())
        }
        if (context.getUser() != "") {
            setViewToList()
            feedPresenter.requestVideos(0, context.getUser())
        }else {
            setViewToSignIn()
        }
    }

    fun setViewToSignIn() {
        refresh.isEnabled = false
        signInLinear.visibility = View.VISIBLE
        listLinear.visibility = View.GONE
    }

    fun setViewToList() {
        refresh.isEnabled = true
        signInLinear.visibility = View.GONE
        listLinear.visibility = View.VISIBLE
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
        layoutManager.setExtraLayoutSpace(resources.displayMetrics.density.toInt() * 3)

        val dividerItemDecoration = DividerItemDecoration(newsRv.context,
                layoutManager.orientation)
        newsRv.addItemDecoration(dividerItemDecoration)

        newsRv.adapter = adapter
        newsRv.layoutManager = layoutManager

        scrollListener = object : EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                progress.visibility = View.VISIBLE
                feedPresenter.requestVideos(totalItemsCount)
            }
        }
        newsRv.addOnScrollListener(scrollListener)
    }

    override fun onLogIn(isSucces: Boolean) {
        if (isSucces) {
            setViewToList()
            feedPresenter.requestVideos(0, context.getUser())
        }else {
            setViewToSignIn()
            Toast.makeText(context, "Wrong credentials", Toast.LENGTH_LONG).show()
        }
    }

    fun initDagger() {
        (activity as MainActivity).feedComponent?.inject(this)
        feedPresenter.setView(this)
    }

}
