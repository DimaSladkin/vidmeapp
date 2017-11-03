package com.sladkin.vidmeapp.presentation.di

import com.sladkin.vidmeapp.VidmeApp
import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class))
        @Singleton
        interface AppComponent {

    fun inject(vidmeApp: VidmeApp)
}
