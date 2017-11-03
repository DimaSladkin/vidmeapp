package com.sladkin.vidmeapp.domain.base

import io.reactivex.Scheduler

interface ObserveOn {

    val scheduler: Scheduler

}
