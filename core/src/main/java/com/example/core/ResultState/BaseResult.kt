package com.example.core.ResultState

sealed class BaseResult {
    data object Success : BaseResult()
    data class Error(val errorMessage: String) : BaseResult()
}
