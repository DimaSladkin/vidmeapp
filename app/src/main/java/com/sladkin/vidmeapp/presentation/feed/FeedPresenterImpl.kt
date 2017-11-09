package com.sladkin.vidmeapp.presentation.feed

/**
 * Created by dima on 06.11.2017.
 */
class FeedPresenterImpl<T : FeedPresenter.FeedView>() : FeedPresenter<T> {

    private var view: T? = null

    override fun requestVideos() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }
}