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

    override fun getNewVideos(offset: Int): Single<List<VideoModel>> {
        return videoApi.getNewVideos(ACCESS_TOKEN, 10, offset).map{ videosMapper.map(it) }
    }

    override fun getFeedVideos(offset: Int): Single<List<VideoModel>> {
        return videoApi.getFeaturedVideos(ACCESS_TOKEN, 10, offset).map {
            videosMapper.map(it)
        }
    }

    override fun getFeaturedVideos(offset: Int): Single<List<VideoModel>> {
        return videoApi.getFeaturedVideos(ACCESS_TOKEN, 10, offset).map {
            videosMapper.map(it)
        }
    }
}