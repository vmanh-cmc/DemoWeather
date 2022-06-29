package com.example.demoweather.ui.detail

import android.annotation.SuppressLint
import android.text.format.DateUtils
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.demoweather.R
import com.example.demoweather.base.BaseFragment
import com.example.demoweather.data.model.geo_coding.ResultGeocoding
import com.example.demoweather.data.model.weather.WeatherResponse
import com.example.demoweather.databinding.FragmentDetailBinding
import com.example.demoweather.ui.MainViewModel
import com.example.demoweather.util.DateTime
import com.example.demoweather.util.Keys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail.*

@AndroidEntryPoint

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    companion object {
        const val TAG = "DetailFragment"
    }

    val activityViewModel: MainViewModel by activityViewModels()

    //1 is Fahrenheit. 2 is Celsius
    var mode = 1

    override val layoutId: Int
        get() = R.layout.fragment_detail

    override fun initView() {
        var cityData = arguments?.getParcelable<ResultGeocoding>(Keys.CITY_DATA)
        Log.d(TAG, "initView: $cityData")
        cityData?.let {
            txt_city_name.text = cityData.name
            activityViewModel.getCurrentData(cityData.lon, cityData.lat)
        }
        rx_list_forecast.layoutManager = LinearLayoutManager(requireContext())
        cbx_change_mode.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                mode = 2
                txt_switch.text = "Switch to Fahrenheit "
            } else {
                mode = 1
                txt_switch.text = "Switch to Celsius"
            }
            activityViewModel.weatherResponse.value?.let {
                updateData(it)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun updateData(data: WeatherResponse) {
        data.let {
            txt_date.text = DateTime.getDate(it.current.dt)
            txt_temperature.text = when (mode) {
                1 -> {
                    it.current.temperature.toString() + "°F"
                }
                2 -> {
                    ((it.current.temperature - 32) / 1.8).toLong().toString() + "°C"
                }
                else -> {
                    it.current.temperature.toString() + "°F"
                }
            }

            txt_humidity.text = it.current.humidity.toString() + "%"
            txt_wind.text = it.current.windSpeed.toString() + "m/s"
            txt_pressure.text = it.current.pressure.toString() + " mm"
            txt_uvi.text = it.current.uvi.toString()
            it.current.weather?.get(0)?.icon?.let {
                Glide.with(requireContext()).load("https://openweathermap.org/img/wn/$it@4x.png").into(icon_weather)
            }
            rx_list_forecast.adapter = ListForecastAdapter(it.hourly.filter { DateUtils.isToday(it.dt.toLong() * 1000) }, mode)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun setupObserver() {
        activityViewModel.weatherResponse.observe(viewLifecycleOwner) {
            it?.let {
                updateData(it)
            }
        }
    }
}
