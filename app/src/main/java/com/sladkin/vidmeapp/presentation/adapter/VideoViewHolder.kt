package com.sladkin.vidmeapp.presentation.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.sladkin.vidmeapp.R
import com.sladkin.vidmeapp.data.entities.VideoModel

class VideoViewHolder(itemView: View,
                      context: Context): RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.video_name)
    lateinit var videoNameTv: TextView

    @BindView(R.id.likes)
    lateinit var likesTv: TextView

    var inflater: LayoutInflater? = null

    init {
        ButterKnife.bind(this, itemView)
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    fun bindViewHolder(videoModel: VideoModel){
        videoNameTv.text = videoModel.name
        likesTv.text = videoModel.likes.toString()
    }

}
