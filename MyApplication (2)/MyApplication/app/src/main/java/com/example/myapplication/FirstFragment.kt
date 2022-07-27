package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var layoutManager: LinearLayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)


        var name1 = ArrayList<String>()
        name1.add("AAA")
        name1.add("BBB")
        name1.add("CCC")
        name1.add("DDD")
        name1.add("EEE")
        name1.add("FFF")

        binding.root.first_rv!!.addItemDecoration(
            EqualSpacingItemDecoration(
                requireActivity(),
                resources.getDimension(R.dimen._6sdp).toInt(),
                EqualSpacingItemDecoration.VERTICAL,
                false
            )
        )

        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.root.first_rv!!.layoutManager = layoutManager
        binding.root.first_rv.adapter = FragmentAdapter(requireActivity(), name1)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}
