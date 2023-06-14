package com.bangkit.gogym.data.api

import com.bangkit.gogym.data.response.LoginResponse
import com.bangkit.gogym.data.response.RegisterResponse
import com.bangkit.gogym.data.response.ScanResponse
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
    ): Call<ScanResponse>


}