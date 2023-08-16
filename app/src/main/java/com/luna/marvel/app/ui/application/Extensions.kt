package com.luna.marvel.app.ui.application

import android.content.Context
import android.util.Log

fun String.log(name: String = javaClass.simpleName) {
    Log.d("<-- $name", this)
}

fun Context.getJsonFromAssets(fileName: String): String {
    val inputStream = assets.open(fileName)
    val size = inputStream.available()
    val buffer = ByteArray(size)
    inputStream.read(buffer)
    inputStream.close()
    return String(buffer, Charsets.UTF_8)
}
