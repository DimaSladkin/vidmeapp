package com.sladkin.vidmeapp.domain.video

import com.sladkin.vidmeapp.data.repository.VideoRepository
import com.sladkin.vidmeapp.data.rest.model.NewVideoResponse
import com.sladkin.vidmeapp.domain.base.ObserveOn
import com.sladkin.vidmeapp.domain.base.SubscribeOn
import com.sladkin.vidmeapp.domain.base.UseCaseSingle
import io.reactivex.Single

class GetNewVideoUseCase(subscribeOn: SubscribeOn, observeOn: ObserveOn,
                         val videoRepository: VideoRepository):
        UseCaseSingle<NewVideoResponse>(subscribeOn, observeOn) {

    override val useCaseSingle: Single<NewVideoResponse>
        get() = videoRepository.getNewVideos()
}