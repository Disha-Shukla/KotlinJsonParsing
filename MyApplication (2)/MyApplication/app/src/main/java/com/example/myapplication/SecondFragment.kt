package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private var layoutManager: LinearLayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater)

        var name1 = ArrayList<String>()
        name1.add("AAA")
        name1.add("BBB")
        name1.add("CCC")
        name1.add("DDD")
        name1.add("EEE")
        name1.add("FFF")

        binding.root.second_rv!!.addItemDecoration(
            EqualSpacingItemDecoration(
                requireActivity(),
                resources.getDimension(R.dimen._6sdp).toInt(),
                EqualSpacingItemDecoration.VERTICAL,
                false
            )
        )

        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.root.second_rv!!.layoutManager = layoutManager
        binding.root.second_rv.adapter = SecondFragmentAdapter(requireActivity(), name1)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
