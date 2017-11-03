package com.sladkin.vidmeapp.domain.base

import io.reactivex.Scheduler

interface SubscribeOn {

    val scheduler: Scheduler

}
