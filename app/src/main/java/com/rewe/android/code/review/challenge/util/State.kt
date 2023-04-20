package com.rewe.android.code.review.challenge.util

sealed class State<out T> {
    data class Success<out T>(val data: T) : State<T>()
    data class Error<out T>(val throwable: Throwable, val msg: String? = null, val data: T? = null) : State<T>()
    data class Loading<out T>(val data: T? = null, val msg: String? = null) : State<T>()
}