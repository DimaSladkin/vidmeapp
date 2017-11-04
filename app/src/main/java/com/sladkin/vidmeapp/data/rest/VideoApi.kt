package com.sladkin.vidmeapp.data.rest

import com.sladkin.vidmeapp.data.rest.model.NewVideoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by dima on 03.11.2017.
 */

interface VideoApi{

    @GET("/videos/new")
    fun getNewVideos(@Query("accesstoken") token: String): Single<NewVideoResponse>
}