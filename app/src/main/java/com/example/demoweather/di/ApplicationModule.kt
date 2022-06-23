package com.example.demoweather.di

import android.util.Log
import com.example.demoweather.BuildConfig
import com.example.demoweather.data.api.ApiService
import com.example.demoweather.data.api.city.CityApiHelper
import com.example.demoweather.data.api.city.CityApiHelperImpl
import com.example.demoweather.data.api.weather.WeatherApiHelper
import com.example.demoweather.data.api.weather.WeatherApiHelperImpl
import com.example.demoweather.repository.city.CityRepository
import com.example.demoweather.repository.city.CityRepositoryImpl
import com.example.demoweather.repository.weather.WeatherRepository
import com.example.demoweather.repository.weather.WeatherRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun provideBaseUrl() = "https://api.openweathermap.org/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        var okhttp = if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor { message -> Log.d("Retrofit", message) }
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        } else OkHttpClient
            .Builder()
            .build()
        return okhttp
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String, moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideCityApiHelper(apiService: ApiService): CityApiHelper = CityApiHelperImpl(apiService)

    @Provides
    @Singleton
    fun provideWeatherApiHelper(apiService: ApiService): WeatherApiHelper = WeatherApiHelperImpl(apiService)

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherApiHelper: WeatherApiHelper): WeatherRepository = WeatherRepositoryImpl(weatherApiHelper)

    @Provides
    @Singleton
    fun provideCityRepository(cityApiHelper: CityApiHelper): CityRepository = CityRepositoryImpl(cityApiHelper)
}