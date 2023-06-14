package com.bangkit.gogym

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkit.gogym.data.api.ApiConfig
import com.bangkit.gogym.data.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    companion object {
        val TAG = "LOGINVIEWMODEL"
    }

    private val _loginUser = MutableLiveData<LoginResponse?>()
    val loginUser: LiveData<LoginResponse?> = _loginUser

    fun loginUser(email: String, pw: String) {
        val client = ApiConfig.getApiService().login(email, pw)
        client.enqueue(object: Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    _loginUser.value = responseBody
                    Log.d(TAG, "onResponse: berhasil")
                }else {
                    Log.e(TAG, "onResponse else: ${response.message()} ", )
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message} ", )
            }

        })
    }

}