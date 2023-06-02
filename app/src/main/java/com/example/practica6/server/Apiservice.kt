package com.example.practica6.server

import com.example.practica6.server.model.BatmanMovies
import retrofit2.http.GET
import retrofit2.http.Query

//https://www.omdbapi.com/?&plot=full&s=batman&apikey=b3061d30

interface Apiservice {
    @GET("?&plot=full&s=batman")
    suspend fun loadMovies(@Query("apikey") apiKey: String) : BatmanMovies
}