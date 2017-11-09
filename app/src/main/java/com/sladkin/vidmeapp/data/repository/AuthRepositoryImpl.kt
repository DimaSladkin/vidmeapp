package com.sladkin.vidmeapp.data.repository

import android.content.Context
import android.util.Log
import com.sladkin.vidmeapp.data.rest.VideoApi
import com.sladkin.vidmeapp.extensions.setUser
import io.reactivex.Single

/**
 * Created by dima on 09.11.2017.
 */
class AuthRepositoryImpl(var context: Context, val videoApi: VideoApi) : AuthRepository {

    override fun getUser(username: String, pass: String): Single<Boolean> {
        return videoApi.getUser(username, pass).doOnSuccess {
            Log.i("onxUser", it.body().toString())
            Log.i("onxUser", it.code().toString())
            if (it.body()!!.status)
                saveUserKey(it.body()!!.auth.token)
        }.map { it.body()?.status }
    }

    fun saveUserKey(userKey: String) {
        context.setUser(userKey)
    }
}