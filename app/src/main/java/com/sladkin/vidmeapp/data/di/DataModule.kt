package com.sladkin.vidmeapp.data.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dima on 03.11.2017.
 */
@Module(includes = arrayOf(NetworkingModule::class, RepositoryModule::class, MappersModule::class))
class DataModule {

    @Provides
    @Singleton
    internal fun provideSharedPrefs(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}