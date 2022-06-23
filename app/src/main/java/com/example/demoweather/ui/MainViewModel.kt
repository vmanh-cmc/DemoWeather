package com.example.demoweather.ui

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.demoweather.base.BaseViewModel
import com.example.demoweather.data.model.geo_coding.ResultGeocoding
import com.example.demoweather.data.model.weather.WeatherResponse
import com.example.demoweather.repository.city.CityRepository
import com.example.demoweather.repository.weather.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var weatherRepository: WeatherRepository

    @Inject
    lateinit var cityRepository: CityRepository

    var weatherResponse = MutableLiveData<WeatherResponse>()
    var listCityResult = MutableLiveData<MutableList<ResultGeocoding>>()

    @SuppressLint("CheckResult")
    fun getCurrentData(long: Double, lat: Double) {
        weatherRepository.getCurrentData(long, lat).subscribeWith(object : DisposableObserver<WeatherResponse>() {
            override fun onNext(t: WeatherResponse) {
                weatherResponse.postValue(t)
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onComplete() {

            }
        })
    }

    @SuppressLint("CheckResult")
    fun searchCityData(searchText: String) {
        cityRepository.searchCityData(searchText).subscribeWith(object : DisposableObserver<MutableList<ResultGeocoding>>() {
            override fun onNext(t: MutableList<ResultGeocoding>) {
                listCityResult.postValue(t)
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onComplete() {

            }
        })
    }

}