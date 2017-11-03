package com.sladkin.vidmeapp

import android.app.Application
import com.sladkin.vidmeapp.presentation.di.AppComponent
import com.sladkin.vidmeapp.presentation.di.AppModule
import com.sladkin.vidmeapp.presentation.di.DaggerAppComponent

class VidmeApp: Application() {

    companion object {
        var vidmeApp: VidmeApp? = null

        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent?.inject(this)
        vidmeApp = this
    }
}
