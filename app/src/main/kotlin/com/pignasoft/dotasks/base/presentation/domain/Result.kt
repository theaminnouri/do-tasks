package com.pignasoft.dotasks.base.presentation.domain

sealed class Result {
        data class Success<T>(val data: List<T>) : Result()
        data class Error(val e: Throwable) : Result()
    }