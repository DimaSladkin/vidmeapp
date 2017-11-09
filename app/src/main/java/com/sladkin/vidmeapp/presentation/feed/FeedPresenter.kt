package com.sladkin.vidmeapp.presentation.feed

import android.content.Context
import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.data.entities.VideoViewHolderModel
import com.sladkin.vidmeapp.presentation.Presenter

/**
 * Created by dima on 06.11.2017.
 */
interface FeedPresenter<T>: Presenter<T> {

    interface FeedView {
        fun onVideosLoaded(list: List<VideoModel>)

        fun onLogIn(isSuccess: Boolean)

        fun onError(error: Throwable)
    }

    fun getLogin(context: Context): Boolean

    fun requstLogin(username: String, pass: String)

    fun requestVideos(offset: Int, token: String)
}