package com.sladkin.vidmeapp.domain.base

import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber

abstract class UseCaseStream<T>(subscribeOn: SubscribeOn, observeOn: ObserveOn) :
        UseCase(subscribeOn, observeOn) {

    private var flowable: Flowable<T>? = null

    fun executeFlowable(subscriber: FlowableSubscriber<T>) {
        if (flowable == null) {
            flowable = useCaseStream
                    .subscribeOn(subscribeOn.scheduler)
                    .observeOn(observeOn.scheduler)
                    .doOnError { flowable = null }
                    .doOnComplete { flowable = null }
                    .doOnCancel { flowable = null }
        }
    }

    protected abstract val useCaseStream: Flowable<T>
}
