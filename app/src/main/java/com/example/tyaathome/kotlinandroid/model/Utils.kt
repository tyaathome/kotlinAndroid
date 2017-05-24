package com.example.tyaathome.kotlinandroid.model

import android.content.Context
import android.content.Intent

/**
 * Created by tyaathome on 2017/5/24.
 */

fun gotoActivity(context: Context, clazz: Class<*>) {
    val intent: Intent = Intent(context, clazz)
    context.startActivity(intent)
}

fun isOdd(x: Int) = x%2 != 0
fun isOdd(x: String) = isOdd(x.toInt())

fun <A,B,C> compose(d: (B) -> C, e: (A) ->B): (A) -> C {
    return { x -> d(e(x))}
}

class Foo
fun function(factory: () -> Foo): Foo {
    val x: Foo = factory()
    return x
}

