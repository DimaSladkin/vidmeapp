package com.sladkin.vidmeapp.presentation.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.sladkin.vidmeapp.presentation.featured.FeaturedFragment
import com.sladkin.vidmeapp.presentation.feed.FeedFragment
import com.sladkin.vidmeapp.presentation.news.NewsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,
                       val fragmentList: List<Fragment>): FragmentPagerAdapter(fragmentManager) {


    override fun getItem(position: Int) = fragmentList[position]

    override fun getCount() = fragmentList.size

    override fun getPageTitle(position: Int) =
            when(fragmentList[position]){
                is FeedFragment -> "Feed"
                is NewsFragment -> "News"
                is FeaturedFragment -> "Featured"
                else -> ""
            }
}
