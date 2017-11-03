package com.sladkin.vidmeapp.presentation.news

/**
 * Created by dima on 03.11.2017.
 */
class NewsPresenterImpl<T: NewsPresenter.NewsView>(): NewsPresenter<T> {

    private var view: T? = null


    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }
}