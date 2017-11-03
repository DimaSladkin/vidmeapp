package com.sladkin.vidmeapp.presentation

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import com.sladkin.vidmeapp.R
import com.sladkin.vidmeapp.presentation.adapter.ViewPagerAdapter
import com.sladkin.vidmeapp.presentation.featured.FeaturedFragment
import com.sladkin.vidmeapp.presentation.feed.FeedFragment
import com.sladkin.vidmeapp.presentation.news.NewsFragment

class MainActivity: AppCompatActivity() {

    @BindView(R.id.tabs)
    lateinit var tabs: TabLayout

    @BindView(R.id.viewpager)
    lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        ButterKnife.bind(this)

        setUpViewPager()
        tabs.setupWithViewPager(viewPager)
    }

    private fun setUpViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager,
                listOf(NewsFragment(), FeaturedFragment(), FeedFragment()))
        viewPager.adapter = viewPagerAdapter
    }
}
