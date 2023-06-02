package com.example.practica6.server.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    @SerializedName("imdbID")
    val imdbID: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Year")
    val year: String
): Serializable