package com.sladkin.vidmeapp.presentation.featured

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.sladkin.vidmeapp.R
import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.presentation.adapter.VideoRecyclerAdapter
import com.sladkin.vidmeapp.presentation.adapter.VideoViewHolder

class FeaturedFragment: Fragment() {

    @BindView(R.id.featured_rv)
    lateinit var featuredRv: RecyclerView

    var videoList: ArrayList<VideoModel> = ArrayList()
    var adapter: RecyclerView.Adapter<VideoViewHolder>? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.featured_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view!!)

        if (view != null) {
            ButterKnife.bind(this, view)
            setUpRecycler()
        }
    }

    fun setUpRecycler() {
        adapter = VideoRecyclerAdapter(context, listOf())

        featuredRv.adapter = adapter
        featuredRv.layoutManager = LinearLayoutManager(context)
    }
}