package com.sladkin.vidmeapp.presentation.news

import android.util.Log
import com.sladkin.vidmeapp.domain.video.GetNewVideoUseCase

/**
 * Created by dima on 03.11.2017.
 */
class NewsPresenterImpl<T: NewsPresenter.NewsView>(val getNewVideoUseCase: GetNewVideoUseCase)
    : NewsPresenter<T> {


    override fun requestNewVideos() {
        getNewVideoUseCase.executeSingle(
                { if (view != null) view?.onVideosLoaded(it)},
                { Log.i("onxNewVideosErr", it.toString()) }
        )
    }

    private var view: T? = null


    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }
}