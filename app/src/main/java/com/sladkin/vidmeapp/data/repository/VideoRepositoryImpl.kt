package com.sladkin.vidmeapp.data.repository

import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.data.mapers.VideosMapper
import com.sladkin.vidmeapp.data.rest.VideoApi
import com.sladkin.vidmeapp.data.rest.model.NewVideoResponse
import io.reactivex.Single

/**
 * Created by dima on 03.11.2017.
 */
class VideoRepositoryImpl(private val videoApi: VideoApi,
                          private val videosMapper: VideosMapper): VideoRepository {

    companion object {

        val ACCESS_TOKEN = "EvDOHVaSrdznhcmh1APT7pdogwa41dIe"
    }

    override fun getNewVideos(): Single<List<VideoModel>> {
        return videoApi.getNewVideos(ACCESS_TOKEN, 10).map{ videosMapper.map(it) }
    }

    override fun getFeedVideos(): Single<List<VideoModel>> {
        return
    }

    override fun getFeaturedVideos(): Single<List<VideoModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}