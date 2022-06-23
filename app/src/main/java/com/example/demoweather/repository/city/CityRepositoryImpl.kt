package com.example.demoweather.repository.city

import com.example.demoweather.data.api.city.CityApiHelper
import com.example.demoweather.data.model.geo_coding.ResultGeocoding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(private val cityApiHelper: CityApiHelper) : CityRepository {
    override fun searchCityData(textSearch: String): Observable<MutableList<ResultGeocoding>> {
        return cityApiHelper.getCity(textSearch).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}