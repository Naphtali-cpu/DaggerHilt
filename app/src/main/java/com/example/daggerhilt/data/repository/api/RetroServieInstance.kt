package com.example.daggerhilt.data.repository.api

import com.example.daggerhilt.network.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServieInstance {

    @GET("repositories")
    fun getDataFromApi(@Query("q") query: String): Call<RecyclerList>

}