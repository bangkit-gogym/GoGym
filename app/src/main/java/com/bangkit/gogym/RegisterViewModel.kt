package com.bangkit.gogym

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkit.gogym.data.api.ApiConfig
import com.bangkit.gogym.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    companion object {
        val TAG = "REGISTERVIEWMODEL"
    }

    private val _registerUser = MutableLiveData<RegisterResponse?>()
    val registerUser: LiveData<RegisterResponse?> = _registerUser

    fun registerUser(name: String, email: String, pw: String) {

        val client = ApiConfig.getApiService().register(name, email, pw)
        client.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    _registerUser.value = responseBody
                    Log.d(TAG, "onResponse: berhasil")
                }else {
                    Log.e(TAG, "onResponse else: ${response.message()} ", )
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message} ", )
            }

        })
    }
}