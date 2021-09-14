package com.example.a1.api

import com.example.a1.Utils.constansts
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {

    val instance: marvel

        init {
            val retrofit = Retrofit.Builder()
                .baseUrl(constansts.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            instance = retrofit.create(marvel::class.java)

        }



}