package com.sladkin.vidmeapp.presentation.news.di

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
}
