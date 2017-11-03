package com.sladkin.vidmeapp.domain.base

import io.reactivex.disposables.Disposable

open class UseCase(protected var subscribeOn: SubscribeOn, protected var observeOn: ObserveOn) {

    protected var disposable: Disposable? = null

    fun dispose() {
        disposable?.dispose()
    }
}