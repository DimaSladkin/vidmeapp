package com.sladkin.vidmeapp.presentation.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import butterknife.BindView
import butterknife.ButterKnife
import com.sladkin.vidmeapp.R
import com.sladkin.vidmeapp.data.entities.VideoModel
import com.squareup.picasso.Picasso

class VideoViewHolder(itemView: View,
                      context: Context) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.video_name)
    lateinit var videoNameTv: TextView

    @BindView(R.id.likes)
    lateinit var likesTv: TextView

    @BindView(R.id.video_view)
    lateinit var videoView: VideoView

    @BindView(R.id.thumb_img)
    lateinit var thumb: ImageView

    var inflater: LayoutInflater? = null

    init {
        ButterKnife.bind(this, itemView)
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    }

    fun bindViewHolder(videoModel: VideoModel) {
        videoNameTv.text = videoModel.name
        likesTv.text = videoModel.likes.toString()
        videoView.setVideoURI(Uri.parse(videoModel.url))
        Picasso.with(itemView.context)
                .load(videoModel.thumbUrl)
                .into(thumb)
        setListeners()
    }

    fun setListeners() {
        thumb.setOnClickListener {
            thumb.visibility = View.INVISIBLE
            if (videoView.visibility == View.INVISIBLE) {
                videoView.visibility = View.VISIBLE
                videoView.start()
                Toast.makeText(itemView.context, "Show", Toast.LENGTH_SHORT).show()
            }
            if (!videoView.isPlaying)
                videoView.resume()
            else
                videoView.pause()
        }
    }

}
