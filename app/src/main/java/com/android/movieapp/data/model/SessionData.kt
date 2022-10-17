package com.android.movieapp.data.model


import com.google.gson.annotations.SerializedName

data class SessionData(
    @SerializedName("session_id")
    val sessionId: String = ""
): BaseData()