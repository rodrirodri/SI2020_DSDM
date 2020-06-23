package br.edu.unisep.myweather.data.local

data class WeatherInfoDto(
    val country: String,
    val city: String,
    val sunset: String,
    val sunrise: String,
    val temperature: Double,
    val weatherType: Int,
    val windSpeed: Double,
    val uvIndex: Double
)