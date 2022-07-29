package com.example.daggerhilt.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServieInstance {

    @GET("repositories")
    fun getDataFromApi(@Query("q") query: String): Call<RecyclerList>

}