package net.developers.api.albumdetails

import com.google.gson.annotations.SerializedName

data class Streamable(
    @SerializedName("#text")
    val text: String,
    val fulltrack: String
)