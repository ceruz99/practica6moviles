package com.example.practica6.server

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OpenMBD {
    private const val urlAPI = "https://www.omdbapi.com/"

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)).build()

    val retrofit: Apiservice = Retrofit.Builder().baseUrl(urlAPI)
        .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build().run {
        create(Apiservice::class.java)
    }
}