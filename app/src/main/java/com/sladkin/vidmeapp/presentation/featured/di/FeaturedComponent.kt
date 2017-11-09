package com.sladkin.vidmeapp.presentation.featured.di

import com.sladkin.vidmeapp.presentation.di.PerActivity
import com.sladkin.vidmeapp.presentation.featured.FeaturedFragment
import dagger.Subcomponent

/**
 * Created by dima on 06.11.2017.
 */
@PerActivity
@Subcomponent(modules = arrayOf(FeaturedModule::class))
interface FeaturedComponent{

    fun inject(featuredFragment: FeaturedFragment)
}