package com.sladkin.vidmeapp.presentation.news

import android.app.Presentation
import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.data.rest.model.NewVideoResponse
import com.sladkin.vidmeapp.presentation.Presenter

interface NewsPresenter<T> : Presenter<T> {

    interface NewsView {
        fun onVideosLoaded(list: List<VideoModel>)

        fun onError(error: Throwable)
    }

    fun requestNewVideos()

}
