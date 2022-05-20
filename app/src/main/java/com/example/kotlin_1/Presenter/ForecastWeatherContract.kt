package com.example.kotlin_1.Presenter

import com.example.kotlin_1.Model.WeatherResponse

interface ForecastWeatherContract {
    interface View {
        fun getSuccess(weatherResponse: WeatherResponse)
        fun getFailure(err: String)
    }

    interface Presenter {
        fun getForecastWeather(lat: String, lon: String, appid: String)
    }
}