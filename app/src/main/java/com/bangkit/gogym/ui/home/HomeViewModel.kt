package com.bangkit.gogym.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkit.gogym.data.api.ApiConfig
import com.bangkit.gogym.data.response.EquipmentItem
import com.bangkit.gogym.data.response.ListEquipmentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    companion object {
        val TAG = "HOMEVIEWMODEL"
    }

    private val _listEquipment = MutableLiveData<List<EquipmentItem>>()
    val listEquipment: LiveData<List<EquipmentItem>> = _listEquipment


    fun getListEquipmet() {

        val client = ApiConfig.getApiService().getEquipment()
        client.enqueue(object: Callback<ListEquipmentResponse> {
            override fun onResponse(
                call: Call<ListEquipmentResponse>,
                response: Response<ListEquipmentResponse>
            ) {
                val responseBody = response.body()
                if(response.isSuccessful) {
                    _listEquipment.value = responseBody?.equipment
                }else {
                    Log.e(TAG, "onResponse: ${response.message()}", )
                }
            }

            override fun onFailure(call: Call<ListEquipmentResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}", )
            }

        })
    }
}