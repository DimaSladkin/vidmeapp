package com.sladkin.vidmeapp.data.di

import com.sladkin.vidmeapp.data.mapers.VideosMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dima on 05.11.2017.
 */
@Module
class MappersModule {

    @Singleton
    @Provides
    fun provideVideosMapper(): VideosMapper = VideosMapper()
}