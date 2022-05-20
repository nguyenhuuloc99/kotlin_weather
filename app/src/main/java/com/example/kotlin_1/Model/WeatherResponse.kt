package com.example.kotlin_1.Model

import com.google.gson.annotations.SerializedName
import kotlin.collections.List

data class WeatherResponse(@SerializedName("list") val weather: ArrayList<com.example.kotlin_1.Model.Weather>) {
}