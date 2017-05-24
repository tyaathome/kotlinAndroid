package com.example.tyaathome.kotlinandroid.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by tyaathome on 2017/5/24.
 */

abstract class BaseActivity(var layout: Int): AppCompatActivity() {

    private var myToast: Toast? = null

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        when {
            myToast == null -> {
                myToast = Toast.makeText(applicationContext, message, duration)
            }
        }
        myToast?.setText(message)
        myToast?.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        initView()
        initEvent()
        initData()
    }

    abstract protected fun initView()
    abstract protected fun initEvent()
    abstract protected fun initData()

}
