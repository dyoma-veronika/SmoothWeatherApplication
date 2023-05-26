package com.example.smoothweatherapplication.domain.model

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>, //map "day" – "weather data"; Int 0 - today
    val currentWeatherData: WeatherData?
)
