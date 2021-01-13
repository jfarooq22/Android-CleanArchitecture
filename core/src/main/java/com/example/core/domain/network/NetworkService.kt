package com.example.core.domain.network


import com.example.core.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.*

interface NetworkService {
    @GET("data/2.5/weather?")
    suspend fun getCurrentWeatherData(@Query("q") cityName: String, @Query("APPID") Key: String?): Response<WeatherResponse>
}