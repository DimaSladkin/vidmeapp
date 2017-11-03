package com.sladkin.vidmeapp

import android.app.Application
import com.sladkin.vidmeapp.presentation.di.AppComponent

class VidmeApp: Application() {

    companion object {
        var vidmeApp: VidmeApp? = null

        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()

        vidmeApp = this
    }
}
