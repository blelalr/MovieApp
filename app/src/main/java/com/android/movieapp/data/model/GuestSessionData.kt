package com.android.movieapp.data.model


import com.google.gson.annotations.SerializedName

data class GuestSessionData (
    @SerializedName("expires_at")
    val expiresAt: String = "",
    @SerializedName("guest_session_id")
    val guestSessionId: String = ""
): BaseData()