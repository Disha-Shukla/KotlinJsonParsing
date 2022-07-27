package com.example.myfirstapplication

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.myfirstapplication.databinding.ListItemBinding
import kotlinx.android.synthetic.main.list_item.view.*

class CustomListAdapter(private val context: Activity, private val MondayArray: ArrayList<Monday>):BaseAdapter() {
    private val layoutInflater: LayoutInflater = context.layoutInflater

    override fun getCount(): Int {
        return MondayArray.size
    }

    override fun getItem(p0: Int): Any {
        return MondayArray.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val binding = ListItemBinding.inflate(layoutInflater, p2, false)
        val rowView = binding.rootRl
        //Log.v("DS","in getView")
        rowView.txtShowTitle.text = MondayArray.get(position).show_title
        rowView.txtShowStartTime.text = MondayArray.get(position).start_time
        rowView.txtShowEndTime.text = MondayArray.get(position).end_time
        Glide.with(context)
            .load(MondayArray.get(position).image)
            .into(rowView.ivShowImage)
        rowView.txtShowDesc.text = MondayArray.get(position).description

        return rowView
    }
}