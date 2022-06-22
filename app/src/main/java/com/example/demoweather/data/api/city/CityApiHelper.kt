package com.example.demoweather.data.api.city

import com.example.demoweather.data.model.geo_coding.ResultGeocoding
import io.reactivex.Observable

interface CityApiHelper {
    fun getCity(city: String): Observable<MutableList<ResultGeocoding>>

}