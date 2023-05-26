package com.example.smoothweatherapplication.presentation.model

import com.example.smoothweatherapplication.domain.model.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
