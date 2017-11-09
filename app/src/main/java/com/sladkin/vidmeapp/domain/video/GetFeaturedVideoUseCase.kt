package com.sladkin.vidmeapp.domain.video

import com.sladkin.vidmeapp.data.entities.VideoModel
import com.sladkin.vidmeapp.data.repository.VideoRepository
import com.sladkin.vidmeapp.data.rest.VideoApi
import com.sladkin.vidmeapp.domain.base.ObserveOn
import com.sladkin.vidmeapp.domain.base.SubscribeOn
import com.sladkin.vidmeapp.domain.base.UseCaseSingle
import io.reactivex.Single

/**
 * Created by dima on 09.11.2017.
 */
class GetFeaturedVideoUseCase(subscribeOn: SubscribeOn, observeOn: ObserveOn, var videoRepository: VideoRepository):
        UseCaseSingle<List<VideoModel>>(subscribeOn, observeOn) {

    var offset: Int? = null

    override val useCaseSingle: Single<List<VideoModel>>
        get() = videoRepository.getFeaturedVideos(offset!!)

    fun setUseCase(offset: Int){
        this.offset = offset
    }
}