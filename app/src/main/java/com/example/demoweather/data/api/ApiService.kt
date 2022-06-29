package com.example.demoweather.data.api

import com.example.demoweather.data.model.geo_coding.ResultGeocoding
import com.example.demoweather.data.model.weather.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("geo/1.0/direct?appid=8a162d98c9520cde549e914e6fd84ec6&limit=7")
    fun getCity(@Query("q") city: String): Observable<MutableList<ResultGeocoding>>

    @GET("data/2.5/onecall?exclude=minutely,daily,alerts&appid=e5a0cb24e205f2a69947b99073200878")
    fun getWeatherData(
        @Query("lon") lon: Double,
        @Query("lat") lat: Double,
        @Query("units") units: String = "imperial"
    ): Observable<WeatherResponse>

}