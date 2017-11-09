package com.sladkin.vidmeapp.presentation.featured.di

import com.sladkin.vidmeapp.data.repository.VideoRepository
import com.sladkin.vidmeapp.domain.base.ObserveOn
import com.sladkin.vidmeapp.domain.base.SubscribeOn
import com.sladkin.vidmeapp.domain.video.GetFeaturedVideoUseCase
import com.sladkin.vidmeapp.presentation.di.PerActivity
import com.sladkin.vidmeapp.presentation.featured.FeaturedPresenter
import com.sladkin.vidmeapp.presentation.featured.FeaturedPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by dima on 06.11.2017.
 */
@Module
class FeaturedModule {

    @Provides
    @PerActivity
    fun providefeaturedPresenter(getFeaturedVideoUseCase: GetFeaturedVideoUseCase):
            FeaturedPresenter<FeaturedPresenter.FeaturedView> = FeaturedPresenterImpl(getFeaturedVideoUseCase)

    @Provides
    @PerActivity
    fun provideGetFeaturedVideoUseCase(subscribeOn: SubscribeOn, observeOn: ObserveOn, videoRepository: VideoRepository):
            GetFeaturedVideoUseCase = GetFeaturedVideoUseCase(subscribeOn, observeOn, videoRepository)

}