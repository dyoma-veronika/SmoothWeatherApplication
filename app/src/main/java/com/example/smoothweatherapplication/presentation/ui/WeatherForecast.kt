package com.example.smoothweatherapplication.presentation.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smoothweatherapplication.presentation.model.WeatherState
import com.example.smoothweatherapplication.presentation.ui.theme.LightBlue


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Today",
                fontSize = 15.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Card(
                backgroundColor = LightBlue,
                shape = RoundedCornerShape(10.dp),
                modifier = modifier.padding(vertical = 4.dp, horizontal = 4.dp)
            ) {
                LazyRow(
                    content = {
                        items(data) { weatherData ->
                            HourlyWeatherDisplay(
                                weatherData = weatherData,
                                modifier = Modifier
                                    .height(100.dp)
                                    .padding(horizontal = 16.dp)
                            )
                        }
                    })
            }
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                backgroundColor = LightBlue,
                shape = RoundedCornerShape(10.dp),
                modifier = modifier.padding(vertical = 4.dp, horizontal = 4.dp)
            ) {
                DailyWeatherDisplay(
                    state = state,
                    modifier = Modifier
                        .height(100.dp)
                        .padding(horizontal = 16.dp)
                )

            }
        }
    }
}