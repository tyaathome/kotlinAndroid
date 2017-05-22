package com.example.tyaathome.kotlinandroid

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var myToast: Toast? = null

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val adapter = MainAdapter(items)
        adapter.setListener {
            position ->
            toast("clicked $position")
        }
        item_list.adapter = adapter
        item_list.layoutManager = LinearLayoutManager(this)

    }

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        when {
            myToast == null -> {
                myToast = Toast.makeText(applicationContext, message, duration)
            }
        }
        myToast?.setText(message)
        myToast?.show()
    }
}
