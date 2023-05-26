package com.example.smoothweatherapplication.domain.repository

import com.example.smoothweatherapplication.domain.model.WeatherInfo
import com.example.smoothweatherapplication.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(latitude: Double, longitude: Double): Resource<WeatherInfo>
}
