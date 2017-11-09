package com.sladkin.vidmeapp.presentation.feed

import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.data.entities.VideoViewHolderModel
import com.sladkin.vidmeapp.presentation.Presenter

/**
 * Created by dima on 06.11.2017.
 */
interface FeedPresenter<T>: Presenter<T> {

    interface FeedView {
        fun onVideosLoaded(list: List<VideoModel>)
    }

    fun requestVideos()
}