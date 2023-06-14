package com.bangkit.gogym.data.response

import com.google.gson.annotations.SerializedName

data class ScanResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)
