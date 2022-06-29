package com.example.demoweather.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoweather.R
import com.example.demoweather.data.model.geo_coding.ResultGeocoding
import kotlinx.android.synthetic.main.item_city.view.*

class ListCityAdapter(var listCity: MutableList<ResultGeocoding> = mutableListOf(), var onItemClick: (item: ResultGeocoding) -> Unit) : RecyclerView.Adapter<ListCityAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_city, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt_city_name.text = listCity[position].name
        holder.itemView.setOnClickListener {
            onItemClick(listCity[position])
        }
    }

    override fun getItemCount(): Int = listCity.size

}