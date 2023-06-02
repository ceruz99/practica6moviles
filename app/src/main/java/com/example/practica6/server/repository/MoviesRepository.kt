package com.example.practica6.server.repository

import com.example.practica6.server.OpenMBD
import com.example.practica6.server.model.BatmanMovies

class MoviesRepository {
    private val apikey = "b3061d30"

    suspend fun loadMovies() : BatmanMovies = OpenMBD.retrofit.loadMovies(apikey)
}