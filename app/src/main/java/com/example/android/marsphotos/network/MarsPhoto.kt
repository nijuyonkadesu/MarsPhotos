package com.example.android.marsphotos.network

import com.squareup.moshi.Json

// values are auto assigned my moshi, by matching variable names with JSON keys
data class MarsPhoto(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String,
)
