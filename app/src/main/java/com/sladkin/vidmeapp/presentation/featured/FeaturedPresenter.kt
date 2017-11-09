package com.sladkin.vidmeapp.presentation.featured

import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.presentation.Presenter

/**
 * Created by dima on 06.11.2017.
 */
interface FeaturedPresenter<T>: Presenter<T> {

    interface FeaturedView{
        fun onVideosLoaded(videos: List<VideoModel>)

        fun onError(error: Throwable)
    }

    fun requestVideos(offset: Int)
}