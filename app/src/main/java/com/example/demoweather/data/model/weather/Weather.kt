package com.example.demoweather.data.model.weather

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    @Json(name = "id")
    val id: Int,
    @Json(name = "icon")
    val icon: String
) : Parcelable