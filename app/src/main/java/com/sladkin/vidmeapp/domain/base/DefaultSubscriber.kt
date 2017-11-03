package com.sladkin.vidmeapp.domain.base

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class DefaultSubscriber<T>: Subscriber<T> {
    override fun onSubscribe(s: Subscription?) {}

    override fun onNext(t: T) {  }

    override fun onComplete() { }

    override fun onError(t: Throwable?) {}

}
