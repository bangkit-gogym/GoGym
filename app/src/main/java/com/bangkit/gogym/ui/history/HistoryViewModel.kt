package com.bangkit.gogym.ui.history

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkit.gogym.data.api.ApiConfig
import com.bangkit.gogym.data.response.HistoryItem
import com.bangkit.gogym.data.response.ListHistoryResponse
import com.bangkit.gogym.ui.home.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryViewModel : ViewModel() {

    companion object {
        val TAG = "HISTORYVIEWMODEL"
    }

    private val _listHistory = MutableLiveData<List<HistoryItem>>()
    val listHistory: LiveData<List<HistoryItem>> = _listHistory

    fun getUserHistory(token: String) {

        val client = ApiConfig.getApiService().getHistory(token)
        client.enqueue(object: Callback<ListHistoryResponse> {
            override fun onResponse(
                call: Call<ListHistoryResponse>,
                response: Response<ListHistoryResponse>
            ) {
                val responseBody = response.body()
                if(response.isSuccessful) {
                    _listHistory.value = responseBody?.history
                }else {
                    Log.e(TAG, "onResponse: ${response.message()}", )
                }
            }

            override fun onFailure(call: Call<ListHistoryResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}", )

            }

        })
    }
}