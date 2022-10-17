package com.android.movieapp.data.model


import com.google.gson.annotations.SerializedName

data class RequestTokenData(
    @SerializedName("expires_at")
    val expiresAt: String = "",
    @SerializedName("request_token")
    val requestToken: String = ""
): BaseData()

