package com.sladkin.vidmeapp.presentation.feed.di

import com.sladkin.vidmeapp.data.repository.AuthRepository
import com.sladkin.vidmeapp.data.repository.VideoRepository
import com.sladkin.vidmeapp.domain.base.ObserveOn
import com.sladkin.vidmeapp.domain.base.SubscribeOn
import com.sladkin.vidmeapp.domain.login.GetUserUseCase
import com.sladkin.vidmeapp.domain.video.GetFeedVideoUseCase
import com.sladkin.vidmeapp.presentation.di.PerActivity
import com.sladkin.vidmeapp.presentation.feed.FeedPresenter
import com.sladkin.vidmeapp.presentation.feed.FeedPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dima on 06.11.2017.
 */

@Module
class FeedModule {

    @Provides
    @PerActivity
    fun provideFeedPresenter(getFeedVideoUseCase: GetFeedVideoUseCase, getUserUseCase: GetUserUseCase)
            : FeedPresenter<FeedPresenter.FeedView>
            = FeedPresenterImpl(getFeedVideoUseCase, getUserUseCase)

    @Provides
    @PerActivity
    fun provideGetUserUseCase(subscribeOn: SubscribeOn, observeOn: ObserveOn,
                              authRepository: AuthRepository): GetUserUseCase
            = GetUserUseCase(subscribeOn, observeOn, authRepository)

    @Provides
    @PerActivity
    fun provideGetFeedVideoUseCase(subscribeOn: SubscribeOn, observeOn: ObserveOn,
                                   videoRepository: VideoRepository): GetFeedVideoUseCase
            = GetFeedVideoUseCase(subscribeOn, observeOn, videoRepository)

}