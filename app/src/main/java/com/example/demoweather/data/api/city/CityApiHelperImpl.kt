package com.example.demoweather.data.api.city

import com.example.demoweather.data.api.ApiService
import com.example.demoweather.data.model.geo_coding.ResultGeocoding
import io.reactivex.Observable
import javax.inject.Inject

class CityApiHelperImpl @Inject constructor(private val apiService: ApiService) : CityApiHelper {
    override fun getCity(city: String): Observable<MutableList<ResultGeocoding>> {
        return apiService.getCity(city)
    }
}