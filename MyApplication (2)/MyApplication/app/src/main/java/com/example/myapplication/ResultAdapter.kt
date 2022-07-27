package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemNamesurnameBinding
import java.util.ArrayList

class ResultAdapter(
    private val mActivity: Activity,
    private val mFixtureTitle: ArrayList<String>?,
    private val ClickListerner: ClickInterfaace

):
    RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    private val layoutInflater: LayoutInflater = mActivity.layoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNamesurnameBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.binding.historyData = mFixtureTitle!!.get(position)

        holder.binding.rootName.setOnClickListener {
            ClickListerner.getSeriesId(mFixtureTitle.get(position)!!)
        }
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

    class ViewHolder(var binding: ItemNamesurnameBinding) : RecyclerView.ViewHolder(
        binding.root

    )
}