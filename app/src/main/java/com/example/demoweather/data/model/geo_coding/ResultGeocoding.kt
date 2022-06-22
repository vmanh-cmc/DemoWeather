package com.example.demoweather.data.model.geo_coding

import com.squareup.moshi.Json

data class ResultGeocoding(
    @Json(name = "name")
    var name: String? = null,

    @Json(name = "lat")
    var lat: Double? = null,

    @Json(name = "lon")
    var lon: Double? = null,

    @Json(name = "country")
    var country: String? = null
)