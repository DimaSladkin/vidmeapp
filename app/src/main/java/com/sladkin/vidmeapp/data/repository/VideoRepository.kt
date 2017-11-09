package com.sladkin.vidmeapp.data.repository

import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.data.rest.model.NewVideoResponse
import io.reactivex.Single

interface VideoRepository {

    fun getNewVideos(offset: Int): Single<List<VideoModel>>

    fun getFeedVideos(offset: Int): Single<List<VideoModel>>

    fun getFeaturedVideos(offset: Int): Single<List<VideoModel>>
}
