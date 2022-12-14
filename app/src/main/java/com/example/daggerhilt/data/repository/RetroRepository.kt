package com.example.daggerhilt.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.daggerhilt.network.RecyclerData
import com.example.daggerhilt.network.RecyclerList
import com.example.daggerhilt.data.repository.api.RetroServieInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(
    private val retroInstance: RetroServieInstance
) {
    fun makeApiCall(query: String, liveDataList: MutableLiveData<List<RecyclerData>>) {
        val call: Call<RecyclerList> = retroInstance.getDataFromApi(query)
        call.enqueue(object : Callback<RecyclerList> {
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                liveDataList.postValue(response.body()?.items!!)
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }
}