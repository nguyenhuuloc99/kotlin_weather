package com.example.kotlin_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_1.Adapter.WeatherAdapter
import com.example.kotlin_1.Model.Weather
import com.example.kotlin_1.Model.WeatherResponse
import com.example.kotlin_1.Presenter.ForecastWeatherContract
import com.example.kotlin_1.Presenter.ForecastWeatherPresent


class MainActivity : AppCompatActivity(), ForecastWeatherContract.View {
    var forecastWeatherPresenter: ForecastWeatherPresent? = null
    var LATITUDE = "21"
    var LONGTITUDE = "105"
    var APP_ID = "2b0f1c2e6a3deab6d7f78949d22deb33"
    private var weatherAdapter: WeatherAdapter? = null
    private val listWeather: ArrayList<Weather> = ArrayList()

    lateinit var recyclerview: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview = findViewById(R.id.recyclerview)
        var linear = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerview.layoutManager = linear
        recyclerview.setHasFixedSize(true)
        forecastWeatherPresenter = ForecastWeatherPresent(this);
        forecastWeatherPresenter!!.getForecastWeather(LATITUDE, LONGTITUDE, APP_ID);

    }

    override fun getSuccess(weatherResponse: WeatherResponse) {
        weatherAdapter = WeatherAdapter(weatherResponse.weather)
        recyclerview.adapter = weatherAdapter

    }

    override fun getFailure(err: String) {

    }
}