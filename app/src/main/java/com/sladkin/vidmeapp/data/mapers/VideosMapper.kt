package com.sladkin.vidmeapp.data.mapers

import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.data.rest.model.NewVideoResponse
import com.sladkin.vidmeapp.data.rest.model.Video

/**
 * Created by dima on 05.11.2017.
 */
class VideosMapper {

    fun map(videoResponse: NewVideoResponse): List<VideoModel> {
        val newList: ArrayList<VideoModel> = ArrayList()
        videoResponse.videos.forEach {
            newList.add(VideoModel(it.title, it.likesCount, it.url, it.thumbnailUrl))
        }
        return newList
    }
}