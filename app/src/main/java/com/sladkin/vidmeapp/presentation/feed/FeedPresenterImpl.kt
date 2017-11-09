package com.sladkin.vidmeapp.presentation.feed

/**
 * Created by dima on 06.11.2017.
 */
class FeedPresenterImpl<T : FeedPresenter.FeedView>() : FeedPresenter<T> {

    private var view: T? = null

    override fun requestVideos(offset: Int) {

    }

    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }
}