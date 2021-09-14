package com.example.a1.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface marvel {

    @GET("character")
    fun getCharacter(
        @Query("ts") ts: String,
        @Query("apiKey") apiKey: String,
        @Query("hash") hash: String

    ): Call<Character>
}