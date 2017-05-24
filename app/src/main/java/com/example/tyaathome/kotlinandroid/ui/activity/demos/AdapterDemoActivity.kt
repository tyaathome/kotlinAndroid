package com.example.tyaathome.kotlinandroid.ui.activity.demos

import android.support.v7.widget.LinearLayoutManager
import com.example.tyaathome.kotlinandroid.R
import com.example.tyaathome.kotlinandroid.model.Data
import com.example.tyaathome.kotlinandroid.model.Forecast
import com.example.tyaathome.kotlinandroid.ui.activity.BaseActivity
import com.example.tyaathome.kotlinandroid.ui.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_adapter_demo.*

class AdapterDemoActivity : BaseActivity(R.layout.activity_adapter_demo) {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun initView() {
        val adapter = MainAdapter(items)
        adapter.setListener {
            position ->
            toast(items[position])
        }
        forecast_list.adapter = adapter
        forecast_list.layoutManager = LinearLayoutManager(this)
    }

    override fun initEvent() {
    }

    override fun initData() {
        val forecast = Forecast(Data("name", "surname"), 27.5f, "Shiny day")
        val forecast2 = forecast.copy(temperature = 30f)
        toast(forecast2.temperature.toString())
    }
}
