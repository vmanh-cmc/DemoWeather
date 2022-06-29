package com.example.demoweather.data.api.weather

import com.example.demoweather.data.model.weather.WeatherResponse
import io.reactivex.Observable

interface WeatherApiHelper {
    fun getWeatherData(lon: Double, lat: Double): Observable<WeatherResponse>
}