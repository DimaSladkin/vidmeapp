package com.sladkin.vidmeapp.presentation.feed

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

class FeedFragment: Fragment() {

    @BindView(R.id.feed_rv)
    lateinit var feedRv: RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.feed_fragment, container, false)


        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (view != null) {
            ButterKnife.bind(this, view)
            setUpRecycler()
        }
    }

    fun setUpRecycler() {
        val adapter = VideoRecyclerAdapter(context, listOf(VideoModel("pervaya xuina", 120),
                VideoModel("vtoraya xuina", 250), VideoModel("tretya xuina", 50)))

        feedRv.adapter = adapter
        feedRv.layoutManager = LinearLayoutManager(context)
    }



}
