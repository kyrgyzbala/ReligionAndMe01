package com.example.religionandme01.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.religionandme01.fragments.ask.QuestionFragment
import com.example.religionandme01.fragments.settings.SettingsFragment

class PagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CategoriesFragment()
            1 -> QuizFragment()
            2 -> FaqFragment()
            3 -> QuestionFragment()
            else -> SettingsFragment()
        }
    }
}