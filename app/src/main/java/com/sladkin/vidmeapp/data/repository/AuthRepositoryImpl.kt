package com.sladkin.vidmeapp.data.repository

import android.content.Context
import com.sladkin.vidmeapp.data.rest.VideoApi
import com.sladkin.vidmeapp.extensions.setUser
import io.reactivex.Single

/**
 * Created by dima on 09.11.2017.
 */
class AuthRepositoryImpl(var context: Context, val videoApi: VideoApi): AuthRepository {

    override fun getUser(username: String, pass: String): Single<Boolean> {
        return videoApi.getUser(username, pass).doOnSuccess { saveUserKey(it.auth.token) }.map { it.status }
    }

    fun saveUserKey(userKey: String) {
        context.setUser(userKey)
    }
}