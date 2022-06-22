package com.example.demoweather.ui

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.demoweather.base.BaseViewModel
import com.example.demoweather.data.model.weather.WeatherResponse
import com.example.demoweather.repository.weather.WeatherRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): BaseViewModel() {

    @Inject
    lateinit var weatherRepositoryImpl: WeatherRepositoryImpl

    var weatherResponse = MutableLiveData<WeatherResponse>()

    @SuppressLint("CheckResult")
    fun getCurrentData() {
        weatherRepositoryImpl.getCurrentData(105.804817, 21.028511).subscribeWith(object : DisposableObserver<WeatherResponse>() {
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

}