package com.sladkin.vidmeapp.presentation.featured

class FeaturedPresenterImpl<T: FeaturedPresenter.FeaturedView>: FeaturedPresenter<T> {

    private var view: T? = null

    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
       view = null
    }

    override fun requestVideos() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
