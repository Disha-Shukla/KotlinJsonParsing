package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemNamesurnameBinding
import com.example.myapplication.databinding.ListItemBinding
import kotlinx.android.synthetic.main.list_item.view.*

class CustomListAdapter (private val context: Activity, private val MondayArray: ArrayList<Monday>):
    BaseAdapter() {

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

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        //val inflater = context.layoutInflater
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        val rowView = binding.rootRl
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