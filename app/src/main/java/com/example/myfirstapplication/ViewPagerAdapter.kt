package com.example.myfirstapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myfirstapplication.fragment.MondayFragment
import com.example.myfirstapplication.fragment.TuesdayFragment


class ViewPagerAdapter (fm: FragmentManager, allShowModel: AllShows): FragmentPagerAdapter(fm){

    private val COUNT = 7
    var allShowModels:AllShows = allShowModel

    override fun getItem(position: Int): Fragment {

          /*var size = allShowModels.Monday.size
                   for (i in 0..size-1) {
                       MondayArray.add(allShowModels.Monday.get(i))
                       TuesdayArray.add(allShowModels.Tuesday.get(i))
                   }*/
        return when (position) {

            0 -> MondayFragment("Monday", allShowModels)
            1 -> MondayFragment("Tuesday", allShowModels)
            2 -> MondayFragment("Wednesday", allShowModels)
            3 -> MondayFragment("Thursday", allShowModels)
            4 -> MondayFragment("Friday", allShowModels)
            5 -> MondayFragment("Saturday", allShowModels)
            6 -> MondayFragment("Sunday", allShowModels)
            else -> MondayFragment("Monday", allShowModels)
        }
    }

    override fun getCount(): Int {
        return COUNT
    }


}