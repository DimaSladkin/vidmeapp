package com.sladkin.vidmeapp.data.repository

import com.sladkin.vidmeapp.data.rest.VideoApi
import com.sladkin.vidmeapp.data.rest.model.NewVideoResponse
import io.reactivex.Single

/**
 * Created by dima on 03.11.2017.
 */
class VideoRepositoryImpl(private val videoApi: VideoApi): VideoRepository {

    override fun getNewVideos(): Single<NewVideoResponse> {
        return videoApi.getNewVideos()
    }
}