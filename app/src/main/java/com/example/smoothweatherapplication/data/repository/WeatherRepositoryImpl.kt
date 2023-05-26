package com.example.smoothweatherapplication.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.smoothweatherapplication.data.remote.api.WeatherApi
import com.example.smoothweatherapplication.data.remote.mapper.toWeatherInfo
import com.example.smoothweatherapplication.domain.model.WeatherInfo
import com.example.smoothweatherapplication.domain.repository.WeatherRepository
import com.example.smoothweatherapplication.util.Resource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(latitude: Double, longitude: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = latitude,
                    long = longitude
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
