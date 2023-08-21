package com.luna.marvel.app.ui.application

import android.util.Log

fun String.log(name: String = javaClass.simpleName) {
    Log.d("<-- $name", this)
}