package com.sladkin.vidmeapp.presentation.feed

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.sladkin.vidmeapp.data.di.`DataModule_ProvideSharedPrefs$app_debugFactory`
import com.sladkin.vidmeapp.domain.login.GetUserUseCase
import com.sladkin.vidmeapp.domain.video.GetFeedVideoUseCase
import com.sladkin.vidmeapp.extensions.getUser

/**
 * Created by dima on 06.11.2017.
 */
class FeedPresenterImpl<T : FeedPresenter.FeedView>(val getFeedVideoUseCase: GetFeedVideoUseCase,
                                                    val getUserUseCase: GetUserUseCase) : FeedPresenter<T> {

    private var view: T? = null

    override fun getLogin(context: Context) = context.getUser() != ""

    override fun requestVideos(offset: Int, token: String) {
        getFeedVideoUseCase.setUseCase(offset, token)
        getFeedVideoUseCase.executeSingle(
                {view?.onVideosLoaded(it)},
                {view?.onError(it)}
        )
    }

    override fun requstLogin(username: String, pass: String) {
        getUserUseCase.setUseCase(username, pass)
        getUserUseCase.executeSingle(
                {view?.onLogIn(it)},
                {view?.onError(it)
                Log.i("onxUser", it.toString())}
        )
    }

    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }
}