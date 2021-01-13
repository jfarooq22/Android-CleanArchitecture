package com.example.core.domain.repository

import android.content.SharedPreferences
import com.example.core.data.model.WeatherResponse
import com.example.core.domain.network.NetworkService
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val networkService: NetworkService, sharedPreferences: SharedPreferences) {
    suspend fun weatherResponse(cityName: String, key:String): Response<WeatherResponse> {
        return networkService.getCurrentWeatherData(cityName,key)
    }
}