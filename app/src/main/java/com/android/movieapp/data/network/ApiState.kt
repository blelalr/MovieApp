package com.android.movieapp.data.network

import com.android.movieapp.data.model.BaseData

sealed class ApiState<out T> {

    object Loading: ApiState<Nothing>()

    data class Success<out T >(val data: T) : ApiState<T>()

    data class Failed(val errorData: BaseData) : ApiState<Nothing>()

}
