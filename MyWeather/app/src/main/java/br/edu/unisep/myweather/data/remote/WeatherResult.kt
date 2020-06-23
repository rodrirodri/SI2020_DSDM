package br.edu.unisep.myweather.data.remote

data class WeatherResult(
    val country_code: String,
    val city_name: String,
    val sunset: String,
    val sunrise: String,
    val temp: Double,
    val weather: WeatherType,
    val wind_spd: Double,
    val uv: Double
)