package com.sladkin.vidmeapp.data.rest

import com.sladkin.vidmeapp.data.rest.model.NewVideoResponse
import com.sladkin.vidmeapp.data.rest.model.auth.UserResponceModel
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by dima on 03.11.2017.
 */

interface VideoApi {

    @GET("/videos/new")
    fun getNewVideos(@Query("accesstoken") token: String,
                     @Query("limit") limit: Int,
                     @Query("offset") offset: Int): Single<NewVideoResponse>

    @GET("/videos/featured")
    fun getFeaturedVideos(@Query("accesstoken") token: String,
                          @Query("limit") limit: Int,
                          @Query("offset") offset: Int): Single<NewVideoResponse>

    @GET("/videos/feed")
    fun getFeedVideos(@Query("accesstoken") token: String,
                      @Query("limit") limit: Int,
                      @Query("offset") offset: Int): Single<NewVideoResponse>

    @POST("/user/create")
    fun getUser(@Query("username") user: String,
                @Query("password") pass: String): Single<Response<UserResponceModel>>

}