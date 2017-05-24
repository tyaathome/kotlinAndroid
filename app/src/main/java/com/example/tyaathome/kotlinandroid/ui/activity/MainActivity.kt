package com.example.tyaathome.kotlinandroid.ui.activity

import android.support.v7.widget.LinearLayoutManager
import com.example.tyaathome.kotlinandroid.R
import com.example.tyaathome.kotlinandroid.model.gotoActivity
import com.example.tyaathome.kotlinandroid.ui.activity.demos.AdapterDemoActivity
import com.example.tyaathome.kotlinandroid.ui.activity.demos.ReflectionDemoActivity
import com.example.tyaathome.kotlinandroid.ui.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val demoItem = listOf(
            "Adapter",
            "Reflection"
    )

    override fun initView() {
        val adapter = MainAdapter(demoItem)
        adapter.setListener {
            position ->
            var intentClass:Class<*>? = null
            when(position) {
                0 -> {
                    intentClass = AdapterDemoActivity::class.java
                }

                1 -> {
                    intentClass = ReflectionDemoActivity::class.java
                }
            }
            if(intentClass != null) {
                gotoActivity(this, intentClass)
            }
            startActivity(intent)
        }
        item_list.layoutManager = LinearLayoutManager(this)
        item_list.adapter = adapter

    }

    override fun initEvent() {
    }

    override fun initData() {

    }



}