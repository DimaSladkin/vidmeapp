package com.sladkin.vidmeapp.presentation.feed.di

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
    fun provideFeedPresenter(): FeedPresenter<FeedPresenter.FeedView> = FeedPresenterImpl()

}