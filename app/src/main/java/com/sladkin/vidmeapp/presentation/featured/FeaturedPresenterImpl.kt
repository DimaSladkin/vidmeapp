package com.sladkin.vidmeapp.presentation.featured

import android.util.Log
import com.sladkin.vidmeapp.domain.video.GetFeaturedVideoUseCase

class FeaturedPresenterImpl<T : FeaturedPresenter.FeaturedView>(val getFeaturedVideoUseCase: GetFeaturedVideoUseCase)
    : FeaturedPresenter<T> {

    private var view: T? = null


    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }

    override fun requestVideos(offset: Int) {
        getFeaturedVideoUseCase.setUseCase(offset)
        getFeaturedVideoUseCase.executeSingle(
                { if (view != null) view?.onVideosLoaded(it)},
                {
                    if (view != null) view?.onError(it)
                    Log.i("onxNewVideosErr", it.toString())
                }
        )
    }
}
