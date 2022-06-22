package com.example.demoweather.data.model.weather

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class WeatherData(
    @Json(name = "dt")
    val dt: String? = null,

    @Json(name = "temp")
    val temperature: Float? = null,

    @Json(name = "feels_like")
    val feelsLike: Float? = null,

    @Json(name = "humidity")
    val humidity: Float? = null,

    @Json(name = "clouds")
    val clouds: Float? = null,

    @Json(name = "wind_speed")
    val windSpeed: Float? = null
) : Parcelable