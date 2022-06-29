package com.example.demoweather.data.model.weather

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherResponse(
    @Json(name = "current")
    val current: WeatherData,

    @Json(name = "hourly")
    val hourly: List<WeatherData>

) : Parcelable