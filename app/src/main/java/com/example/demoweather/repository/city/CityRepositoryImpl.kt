package com.example.demoweather.repository.city

import com.example.demoweather.data.api.city.CityApiHelper
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(private val cityApiHelper: CityApiHelper) : CityRepository {


}