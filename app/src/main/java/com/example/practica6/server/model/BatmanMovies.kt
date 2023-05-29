package com.example.practica6.server.model


import com.google.gson.annotations.SerializedName

data class BatmanMovies(
    @SerializedName("Response")
    val response: String?,
    @SerializedName("Movie")
    val movies: List<Movie?>?,
    @SerializedName("totalResults")
    val totalResults: String?
)