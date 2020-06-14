package com.example.religionandme01

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadLocale()

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        nav_bottom_view.setOnNavigationItemSelectedListener(this)
        val sectionPagerAdapter = com.example.religionandme01.fragments.PagerAdapter(this)
        view_pager.adapter = sectionPagerAdapter


        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        nav_bottom_view.menu.findItem(R.id.categories).isChecked = true
                        title = getString(R.string.categories)
                    }
                    1 -> {
                        nav_bottom_view.menu.findItem(R.id.quiz).isChecked = true
                        title = getString(R.string.quiz)
                    }
                    2 -> {
                        nav_bottom_view.menu.findItem(R.id.faq).isChecked = true
                        title = getString(R.string.faq)
                    }
                    3 -> {
                        nav_bottom_view.menu.findItem(R.id.questions).isChecked = true
                        title = getString(R.string.questions)
                    }
                    else -> {
                        nav_bottom_view.menu.findItem(R.id.settings).isChecked = true
                        title = getString(R.string.settings)
                    }
                }
            }
        })
    }

    private fun loadLocale() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")!!
        setLocale(language, 2)
    }

    @Suppress("DEPRECATION")
    private fun setLocale(lang: String, code: Int) {

        val locale = Locale(lang)

        Locale.setDefault(locale)

        val config = Configuration()

        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", lang)
        editor.apply()

        if (code == 1)
            this.recreate()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        view_pager.currentItem = when (item.itemId) {
            R.id.categories -> {
                title = getString(R.string.categories)
                0
            }
            R.id.quiz -> {
                title = getString(R.string.quiz)
                1
            }
            R.id.faq -> {
                title = getString(R.string.faq)
                2
            }
            R.id.questions -> {
                title = getString(R.string.questions)
                3
            }
            else -> {
                title = getString(R.string.settings)
                4
            }
        }

        return true
    }
}