package com.android.movieapp.data.model


import com.google.gson.annotations.SerializedName

data class SessionWithLoginReqData(
    @SerializedName("password")
    val password: String = "",
    @SerializedName("request_token")
    val requestToken: String = "",
    @SerializedName("username")
    val username: String = ""
)