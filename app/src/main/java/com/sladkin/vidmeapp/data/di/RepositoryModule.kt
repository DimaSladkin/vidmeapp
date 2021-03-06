package com.sladkin.vidmeapp.data.di

import android.content.Context
import com.sladkin.vidmeapp.data.mapers.VideosMapper
import com.sladkin.vidmeapp.data.repository.AuthRepository
import com.sladkin.vidmeapp.data.repository.AuthRepositoryImpl
import com.sladkin.vidmeapp.data.repository.VideoRepository
import com.sladkin.vidmeapp.data.repository.VideoRepositoryImpl
import com.sladkin.vidmeapp.data.rest.VideoApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {


    @Provides
    @Singleton
    fun provideVideoRepository(videoApi: VideoApi, videosMapper: VideosMapper)
            : VideoRepository = VideoRepositoryImpl(videoApi, videosMapper)

    @Provides
    @Singleton
    fun provideAuthRepository(context: Context, videoApi: VideoApi): AuthRepository  =
            AuthRepositoryImpl(context, videoApi)
}