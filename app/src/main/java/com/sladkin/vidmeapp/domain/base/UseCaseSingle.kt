package com.sladkin.vidmeapp.domain.base

import io.reactivex.Single

/**
 * Created by dima on 03.11.2017.
 */
abstract class UseCaseSingle<T>(subscribeOn: SubscribeOn, observeOn: ObserveOn): UseCase(subscribeOn, observeOn){

    private var single: Single<T>? = null

    fun executeSingle(onSuccess: (T) -> Unit, onError: (Throwable) -> Unit) {
        if (single == null) {
            single = useCaseSingle
                    .subscribeOn(subscribeOn.scheduler)
                    .observeOn(observeOn.scheduler)
                    .doOnSuccess { single = null }
                    .doOnError{ single = null }
        }
        disposable = single?.subscribe({ onSuccess(it)}, { onError(it) })
    }

    protected abstract val useCaseSingle: Single<T>
}