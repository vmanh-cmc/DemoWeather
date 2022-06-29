package com.example.demoweather.data.api.weather

import com.example.demoweather.data.api.ApiService
import com.example.demoweather.data.model.weather.WeatherResponse
import io.reactivex.Observable
import javax.inject.Inject

class WeatherApiHelperImpl @Inject constructor(private val apiService: ApiService) : WeatherApiHelper {
    override fun getWeatherData(lon: Double, lat: Double): Observable<WeatherResponse> {
        return apiService.getWeatherData(lon, lat)
    }
}