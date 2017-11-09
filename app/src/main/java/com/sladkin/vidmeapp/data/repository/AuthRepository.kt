package com.sladkin.vidmeapp.data.repository

import io.reactivex.Single

/**
 * Created by dima on 09.11.2017.
 */
interface AuthRepository {

    fun getUser(username: String, pass: String): Single<Boolean>
}