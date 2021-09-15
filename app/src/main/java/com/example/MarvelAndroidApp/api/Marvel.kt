package com.example.MarvelAndroidApp.api



import com.example.MarvelAndroidApp.models.characters.characters
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface Marvel {

    @GET("characters")
    fun getData(
        @Query("ts") ts: String?,
        @Query("apikey") apiKey: String?,
        @Query("hash") hash: String?
    ): Call<characters>


}