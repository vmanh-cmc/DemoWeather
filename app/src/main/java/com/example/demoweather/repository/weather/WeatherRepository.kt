package com.example.demoweather.repository.weather

import com.example.demoweather.data.model.weather.WeatherResponse
import io.reactivex.Observable

interface WeatherRepository {

    fun getCurrentData(lon: Double, lat: Double) : Observable<WeatherResponse>

    fun getForecastData()

}