package com.example.tyaathome.kotlinandroid.ui.activity.demos

import android.support.v7.widget.LinearLayoutManager
import com.example.tyaathome.kotlinandroid.R
import com.example.tyaathome.kotlinandroid.model.Foo
import com.example.tyaathome.kotlinandroid.model.compose
import com.example.tyaathome.kotlinandroid.model.function
import com.example.tyaathome.kotlinandroid.model.isOdd
import com.example.tyaathome.kotlinandroid.ui.activity.BaseActivity
import com.example.tyaathome.kotlinandroid.ui.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_reflection_demo.*

class ReflectionDemoActivity : BaseActivity(R.layout.activity_reflection_demo) {

    private val items = listOf(
            "Test0",
            "Test1",
            "Test2"
    )

    override fun initView() {
        val adapter = MainAdapter(items)
        adapter.setListener {
            position ->
            fun length(x: String) = x.length
            when(position) {
                0 -> {
                    val number = listOf(1,2,3)
                    val number2 = listOf("1", "2", "3")
                    println(number.filter {
                        it -> isOdd(it)
                    })
                    println(number2.filter {
                        it -> isOdd(it)
                    })
                    println(number.filter(::isOdd))
                    println(number2.filter(::isOdd))
                }

                1 -> {
                    val predicate1: (Int) -> Boolean = ::isOdd
                    val predicate2: (String) -> Boolean = ::isOdd
                    val oddLength = compose(::isOdd, ::length)
                    val map = listOf("a", "ab", "abc")
                    println(map.map(oddLength))
                }

                2 -> {
                    println(function(::Foo))
                }
            }
            toast(position.toString())
        }

        test_list.adapter = adapter
        test_list.layoutManager = LinearLayoutManager(this)

    }

    override fun initEvent() {
    }

    override fun initData() {
    }

}
