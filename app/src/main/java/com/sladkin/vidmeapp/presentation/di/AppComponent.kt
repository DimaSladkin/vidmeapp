package com.sladkin.vidmeapp.presentation.di

import com.sladkin.vidmeapp.VidmeApp
import com.sladkin.vidmeapp.data.di.DataModule
import com.sladkin.vidmeapp.presentation.news.di.NewsComponent
import com.sladkin.vidmeapp.presentation.news.di.NewsModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class, DataModule::class))
@Singleton
interface AppComponent {

    fun provideNewsComponent(newsModule: NewsModule): NewsComponent

    fun getRetrofit(): Retrofit

    fun inject(vidmeApp: VidmeApp)
}
