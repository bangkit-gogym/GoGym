package com.bangkit.gogym.data.api

import com.bangkit.gogym.data.response.LoginResponse
import com.bangkit.gogym.data.response.RegisterResponse
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


}