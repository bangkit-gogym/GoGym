package com.bangkit.gogym.data.response

import com.google.gson.annotations.SerializedName

data class ListHistoryResponse (

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("photo")
    val history: ArrayList<HistoryItem>
)

data class HistoryItem(
//    @field:SerializedName("id")
//    val id: String,

    @field:SerializedName("predictedname")
    val name: String,

    @field:SerializedName("filepath")
    val photoUrl: String,

    @field:SerializedName("created_at")
    val date: String,


)
