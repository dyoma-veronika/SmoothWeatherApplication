package com.example.smoothweatherapplication.presentation.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smoothweatherapplication.presentation.model.WeatherState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DailyWeatherDisplay(
    state: WeatherState,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black
) {
    val currentDate = LocalDate.now()
    val dateFormatter = DateTimeFormatter.ofPattern("dd/MM")
    val formattedDate = currentDate.format(dateFormatter)

    val days = mutableListOf<LocalDate>()
    for (i in 0..6) {
        days.add(currentDate.plusDays(i.toLong()))
    }

    LazyRow(
        content = {
            items(days) { date ->
            var currentDayIndex = 0
            Column(
                modifier = modifier.padding(vertical = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = date.format(dateFormatter),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = textColor,
                    fontWeight = FontWeight.Bold

                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = " max ${state.weatherInfo?.weatherDataPerDay?.get(currentDayIndex)
                        ?.maxByOrNull { 
                            it.temperatureCelsius 
                        }?.temperatureCelsius?.toString() ?: ""}°C",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = textColor,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = " min ${state.weatherInfo?.weatherDataPerDay?.get(currentDayIndex)
                        ?.minByOrNull { it.temperatureCelsius }
                        ?.temperatureCelsius?.toString() ?: ""}°C",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = textColor,
                    fontSize = 15.sp
                )
            }
            currentDayIndex++
        }
    })

}
