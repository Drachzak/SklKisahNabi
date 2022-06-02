package com.dzak.sklkisahnabi.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dzak.sklkisahnabi.fragment.NabiFragment
import com.dzak.sklkisahnabi.fragment.RasulFragment

class TabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                NabiFragment()
            }
            1 -> {
                RasulFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}