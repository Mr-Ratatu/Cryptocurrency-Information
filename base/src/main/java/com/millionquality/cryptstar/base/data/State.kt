package com.millionquality.cryptstar.base.data

sealed class State<out T> {

    object Loading : State<Nothing>()

    class Success<T>(val data: T) : State<T>()

    class Error(val exception: Throwable) : State<Nothing>()
}
