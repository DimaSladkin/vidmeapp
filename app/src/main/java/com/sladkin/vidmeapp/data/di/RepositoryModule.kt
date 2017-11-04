package com.sladkin.vidmeapp.data.di

import com.sladkin.vidmeapp.data.repository.VideoRepositoryImpl
import com.sladkin.vidmeapp.data.rest.VideoApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideVideoRepository(videoApi: VideoApi) = VideoRepositoryImpl(videoApi)
}