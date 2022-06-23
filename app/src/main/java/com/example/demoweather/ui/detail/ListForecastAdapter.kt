package com.example.demoweather.ui.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoweather.R
import com.example.demoweather.data.model.weather.WeatherData
import com.example.demoweather.util.DateTime
import kotlinx.android.synthetic.main.item_forecast.view.*

class ListForecastAdapter(var listForecast: List<WeatherData> = mutableListOf(), var mode: Int) : RecyclerView.Adapter<ListForecastAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = listForecast[position]
        holder.itemView.txt_time.text = DateTime.getTime(data.dt)
        data.weather?.get(0)?.icon?.let {
            Glide.with(holder.itemView.context).load("https://openweathermap.org/img/wn/$it@4x.png").into(holder.itemView.icon_weather)
            holder.itemView.icon_weather.visibility = View.VISIBLE
        } ?: kotlin.run {
            holder.itemView.icon_weather.visibility = View.GONE
        }
         when (mode) {
            1 -> {
                holder.itemView.temperature.text = data.temperature.toString() + "°F"
                holder.itemView.feels_like.text = data.feelsLike.toString() + "°F"
            }
            2 -> {
                holder.itemView.temperature.text = ((data.temperature - 32) / 1.8).toLong().toString() + "°C"
                holder.itemView.feels_like.text = ((data.feelsLike - 32) / 1.8).toLong().toString() + "°C"
            }
         }
    }

    override fun getItemCount(): Int = listForecast.size

}