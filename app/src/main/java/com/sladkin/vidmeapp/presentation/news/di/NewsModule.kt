package com.sladkin.vidmeapp.presentation.news.di

import com.sladkin.vidmeapp.data.repository.VideoRepository
import com.sladkin.vidmeapp.domain.base.ObserveOn
import com.sladkin.vidmeapp.domain.base.SubscribeOn
import com.sladkin.vidmeapp.domain.video.GetNewVideoUseCase
import com.sladkin.vidmeapp.presentation.di.PerActivity
import com.sladkin.vidmeapp.presentation.news.NewsPresenter
import com.sladkin.vidmeapp.presentation.news.NewsPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class NewsModule {

    @Provides
    @PerActivity
    fun provideNewsPresenter(): NewsPresenter<NewsPresenter.NewsView> = NewsPresenterImpl()

    @Provides
    @PerActivity
    fun provideGetNewViedoUseCase(subscribeOn: SubscribeOn, observeOn: ObserveOn,
                                  videoRepository: VideoRepository) =
            GetNewVideoUseCase(subscribeOn, observeOn, videoRepository)
}
