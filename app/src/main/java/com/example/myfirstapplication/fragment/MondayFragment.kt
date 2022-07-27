package com.example.myfirstapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstapplication.AllShows
import com.example.myfirstapplication.CustomListAdapter
import com.example.myfirstapplication.Monday
import com.example.myfirstapplication.R
import com.example.myfirstapplication.databinding.FragmentMondayBinding
import kotlinx.android.synthetic.main.fragment_monday.*

class MondayFragment(dayValue: String, allShowModel: AllShows) : Fragment() {

    private lateinit var binding: FragmentMondayBinding
    private var layoutManager: LinearLayoutManager? = null
    var allShowModels:AllShows = allShowModel
    var day:String = dayValue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMondayBinding.inflate(layoutInflater)
        var size = allShowModels.Monday.size
        when(day){
            "Monday" -> size = allShowModels.Monday.size
            "Tuesday" -> size = allShowModels.Tuesday.size
            "Wednesday" -> size = allShowModels.Wednesday.size
            "Sunday" -> size = allShowModels.Sunday.size
            "Thursday" -> size = allShowModels.Thursday.size
            "Friday" -> size = allShowModels.Friday.size
            "Saturday" -> size = allShowModels.Saturday.size
            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }

        var MondayArray : ArrayList<Monday> = ArrayList()
        for (i in 0..size-1) {
            when (day) {
                "Monday" -> MondayArray.add(allShowModels.Monday.get(i))
                "Tuesday" -> MondayArray.add(allShowModels.Tuesday.get(i))
                "Wednesday" -> MondayArray.add(allShowModels.Wednesday.get(i))
                "Thursday" -> MondayArray.add(allShowModels.Thursday.get(i))
                "Friday" -> MondayArray.add(allShowModels.Friday.get(i))
                "Saturday" -> MondayArray.add(allShowModels.Saturday.get(i))
                "Sunday" -> MondayArray.add(allShowModels.Sunday.get(i))
                else -> { // Note the block
                    print("x is neither 1 nor 2")
                }
            }

            //TuesdayArray.add(allShowModels.Tuesday.get(i))
        }
        binding.listView.adapter =CustomListAdapter(requireActivity(), MondayArray)
        return binding.root
    }

}