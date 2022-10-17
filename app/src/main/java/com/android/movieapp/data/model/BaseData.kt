package com.android.movieapp.data.model

import com.google.gson.annotations.SerializedName

open class BaseData {
    @SerializedName("success")
    var success: Boolean = false
    @SerializedName("status_code")
    var statusCode: Int = 0
    @SerializedName("status_message")
    var statusMessage: String = ""
}