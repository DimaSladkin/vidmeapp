package com.sladkin.vidmeapp.presentation.news.di

import com.sladkin.vidmeapp.presentation.di.PerActivity
import com.sladkin.vidmeapp.presentation.news.NewsFragment
import dagger.Subcomponent

/**
 * Created by dima on 03.11.2017.
 */

@PerActivity
@Subcomponent(modules = arrayOf(NewsModule::class))
interface NewsComponent {

    fun inject(newsFragment: NewsFragment)
}