package com.bangkit.gogym.data.response

import com.google.gson.annotations.SerializedName

data class EquipmentDetailResponse (
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("equipment")
    val equipment: EquipmentItem
)

