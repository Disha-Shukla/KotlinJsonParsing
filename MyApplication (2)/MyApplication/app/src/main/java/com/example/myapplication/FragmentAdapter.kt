package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemFragmentFirstBinding
import com.example.myapplication.databinding.ItemNamesurnameBinding
import java.util.ArrayList

class FragmentAdapter (

    private val mActivity: Activity,
    private val mFixtureTitle: ArrayList<String>?,
    //private val ClickListerner: ClickInterfaace
):
    RecyclerView.Adapter<FragmentAdapter.ViewHolder>() {

    private val layoutInflater: LayoutInflater = mActivity.layoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFragmentFirstBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.binding.txtMatchName.text = mFixtureTitle!!.get(position)
    }

    override fun getItemCount(): Int {
        return mFixtureTitle!!.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class ViewHolder(var binding: ItemFragmentFirstBinding) : RecyclerView.ViewHolder(
        binding.rootcard

    )
}