package com.sladkin.vidmeapp.presentation.feed.di

import com.sladkin.vidmeapp.presentation.di.PerActivity
import com.sladkin.vidmeapp.presentation.feed.FeedFragment
import dagger.Subcomponent

/**
 * Created by dima on 06.11.2017.
 */

@PerActivity
@Subcomponent(modules = arrayOf(FeedModule::class))
interface FeedComponent {

    fun inject(feedFragment: FeedFragment)
}