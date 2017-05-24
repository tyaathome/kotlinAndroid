package com.example.tyaathome.kotlinandroid.model

/**
 * Created by tyaathome on 2017/5/23.
 */

data class Forecast(val data: Data, val temperature: Float, val describe:String)

data class Data(var name: String, var surname: String)

