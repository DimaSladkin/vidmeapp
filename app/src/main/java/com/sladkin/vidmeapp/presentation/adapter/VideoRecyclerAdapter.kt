package com.sladkin.vidmeapp.presentation.adapter

import android.app.FragmentBreadCrumbs
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sladkin.vidmeapp.R
import com.sladkin.vidmeapp.data.entities.VideoModel

class VideoRecyclerAdapter(val context: Context,
                           val videos: List<VideoModel>) : RecyclerView.Adapter<VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.video_item, parent, false)
        return VideoViewHolder(itemView, context)
    }

    override fun onBindViewHolder(holder: VideoViewHolder?, position: Int) {
        holder?.bindViewHolder(videos[position])
    }

    override fun getItemCount() = videos.size
}
