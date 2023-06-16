package com.bangkit.gogym.data.api

import com.bangkit.gogym.data.response.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name : String,
        @Field("email") email : String,
        @Field("password") password : String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email : String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @Multipart
    @POST("equipments/detection/post")
    fun scan(
        @Header("Authorization") token: String,
        @Part photo: MultipartBody.Part,
        @Part("predictedname") predictedname : String
    ): Call<ScanResponse>

    @GET("equipments")
    fun getEquipment(): Call<ListEquipmentResponse>

    @GET("equipments/detection/history")
    fun getHistory(
        @Header("Authorization") token: String
    ): Call<ListHistoryResponse>

    @GET("equipments/{id}")
    fun getEquipmentDetail(@Path("id") id: Int): Call<EquipmentDetailResponse>


}