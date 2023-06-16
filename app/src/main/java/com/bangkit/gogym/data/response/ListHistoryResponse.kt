package com.bangkit.gogym.data.response

import com.google.gson.annotations.SerializedName

data class ListHistoryResponse (

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("equipment")
    val equipment: ArrayList<HistoryItem>
)

data class HistoryItem(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("ref1Url")
    val ref1Url: String,

    @field:SerializedName("ref2Url")
    val ref2Url: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("photoUrl")
    val photoUrl: String,
)
