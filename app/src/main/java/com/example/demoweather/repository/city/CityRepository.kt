package com.example.demoweather.repository.city

import com.example.demoweather.data.model.geo_coding.ResultGeocoding
import io.reactivex.Observable

interface CityRepository {
    fun searchCityData(textSearch: String): Observable<MutableList<ResultGeocoding>>
}