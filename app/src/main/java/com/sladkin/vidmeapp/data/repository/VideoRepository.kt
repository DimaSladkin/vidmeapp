package com.sladkin.vidmeapp.data.repository

import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.data.rest.model.NewVideoResponse
import io.reactivex.Single

interface VideoRepository {

    fun getNewVideos(): Single<List<VideoModel>>
}
