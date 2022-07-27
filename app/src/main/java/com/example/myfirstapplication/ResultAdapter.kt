package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.databinding.RowItemBinding

class ResultAdapter
    (val mainActivity: MainActivity, val itemarraylist: ArrayList<String>)
    : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {
    private val layoutInflater: LayoutInflater = mainActivity.layoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultAdapter.ViewHolder {
        val binding = RowItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.txtItem.text = itemarraylist.get(position)
    }

    override fun getItemCount(): Int {
       return itemarraylist.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class ViewHolder(var binding: RowItemBinding) : RecyclerView.ViewHolder(
        binding.root
    )

}
