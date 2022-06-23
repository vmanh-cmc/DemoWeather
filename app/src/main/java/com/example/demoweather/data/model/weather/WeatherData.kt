package com.example.demoweather.data.model.weather

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class WeatherData(
    @Json(name = "dt")
    val dt: String,

    @Json(name = "temp")
    val temperature: Float,

    @Json(name = "feels_like")
    val feelsLike: Float,

    @Json(name = "humidity")
    val humidity: Float? = null,

    @Json(name = "clouds")
    val clouds: Float? = null,

    @Json(name = "wind_speed")
    val windSpeed: Float? = null,

    @Json(name = "pressure")
    val pressure: Float? = null,

    @Json(name = "uvi")
    val uvi: Float? = null,

    @Json(name = "weather")
    val weather: List<Weather>? = null
) : Parcelable