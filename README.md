# SmoothWeatherApplication
It is a smooth app that displays the weather.

Open API: https://open-meteo.com/en/docs 

Stack: Kotlin, Jetpack Compose, Retrofit2, Dagger-Hilt

Url: https://api.open-meteo.com/v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl

where: 

— hourly: A list of weather variables which should be returned. Values can be comma separated, or multiple &hourly= parameter in the URL can be used. — temperature_2m: Air temperature at 2 meters above ground. °C

— weathercode: Weather condition as a numeric code. 

— relativehumidity_2m: Relative humidity at 2 meters above ground. %

— windspeed_10m: Wind speed at 10 meters above ground. km/h

— pressure_msl: Atmospheric air pressure reduced to mean sea level (msl). hPa  


The app shows the current weather in the device's location at the current time. It also provides hourly weather for the current day.

![](https://github.com/dyoma-veronika/SmoothWeatherApplication/blob/master/Screenshot.png)
