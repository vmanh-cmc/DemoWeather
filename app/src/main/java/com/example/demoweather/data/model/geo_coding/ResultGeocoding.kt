package com.example.demoweather.data.model.geo_coding

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultGeocoding(
    @Json(name = "name")
    var name: String,

    @Json(name = "lat")
    var lat: Double,

    @Json(name = "lon")
    var lon: Double,

    @Json(name = "country")
    var country: String
) : Parcelable