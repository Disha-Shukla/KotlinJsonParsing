package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentMainActivityBinding
import com.google.android.material.tabs.TabLayout


class MainFragmentActivity : AppCompatActivity() {

    private lateinit var binding: FragmentMainActivityBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        setupViewPager()
    }
    private fun setupViewPager() {
        val viewPager = binding.viewpager
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

        val tab = binding.tabLayout
        tab!!.addTab(tab!!.newTab().setText("UpComing"))
        tab!!.addTab(tab!!.newTab().setText("Result"))
        //tabLayout!!.addTab(tabLayout!!.newTab().setText("Movie"))
        tab!!.tabGravity = TabLayout.GRAVITY_FILL

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        tab!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
                }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}