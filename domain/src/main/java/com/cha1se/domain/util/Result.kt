package com.cha1se.domain.util

sealed interface Result<out T> {
    data class Success<out T>(val data: T): Result<T>
    data class Error(val error: Throwable): Result<Nothing>
    data object Loading: Result<Nothing>

    companion object {
        fun <T> success(data: T): Result<T> = Success(data)
        fun error(exception: Throwable): Result<Nothing> = Error(exception)
        fun loading(): Result<Nothing> = Loading
    }
}