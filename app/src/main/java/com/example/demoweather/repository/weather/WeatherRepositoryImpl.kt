package com.example.demoweather.repository.weather

import com.example.demoweather.data.api.weather.WeatherApiHelper
import com.example.demoweather.data.model.weather.WeatherResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherApiHelper: WeatherApiHelper) : WeatherRepository {
    override fun getCurrentData(lon: Double, lat: Double): Observable<WeatherResponse> {
        return weatherApiHelper.getWeatherData(lon, lat).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    override fun getForecastData() {

    }


}