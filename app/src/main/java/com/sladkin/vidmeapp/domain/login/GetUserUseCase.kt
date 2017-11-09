package com.sladkin.vidmeapp.domain.login

import com.sladkin.vidmeapp.data.repository.AuthRepository
import com.sladkin.vidmeapp.data.repository.VideoRepository
import com.sladkin.vidmeapp.domain.base.ObserveOn
import com.sladkin.vidmeapp.domain.base.SubscribeOn
import com.sladkin.vidmeapp.domain.base.UseCaseSingle
import io.reactivex.Single

/**
 * Created by dima on 09.11.2017.
 */
class GetUserUseCase(subscribeOn: SubscribeOn, observeOn: ObserveOn, var authRepository: AuthRepository):
        UseCaseSingle<Boolean>(subscribeOn, observeOn) {

    var username: String? = null
    var pass: String? = null

    override val useCaseSingle: Single<Boolean>
        get() = authRepository.getUser(username!!, pass!!)

    fun setUseCase(username: String, pass: String) {
        this.username = username
        this.pass = pass
    }
}