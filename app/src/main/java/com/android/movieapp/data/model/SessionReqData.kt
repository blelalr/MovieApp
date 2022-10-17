package com.android.movieapp.data.model


import com.google.gson.annotations.SerializedName

data class SessionReqData(
    @SerializedName("request_token")
    val requestToken: String = ""
)