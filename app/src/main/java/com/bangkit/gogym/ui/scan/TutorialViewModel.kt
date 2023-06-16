package com.bangkit.gogym.ui.scan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkit.gogym.data.api.ApiConfig
import com.bangkit.gogym.data.response.EquipmentDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TutorialViewModel : ViewModel() {
    companion object {
        val TAG = "TUTORIALVIEWMODEL"
    }

    private val _equipmentDetail = MutableLiveData<EquipmentDetailResponse?>()
    val equipmentDetail: LiveData<EquipmentDetailResponse?> = _equipmentDetail

    fun getEquipmentDetail(id: Int) {

        val client = ApiConfig.getApiService().getEquipmentDetail(id)
        client.enqueue(object: Callback<EquipmentDetailResponse> {
            override fun onResponse(
                call: Call<EquipmentDetailResponse>,
                response: Response<EquipmentDetailResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    _equipmentDetail.value = responseBody
                }else {
                    Log.e(TAG, "onResponse: ${response.message()}", )
                }
            }

            override fun onFailure(call: Call<EquipmentDetailResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
    }
}