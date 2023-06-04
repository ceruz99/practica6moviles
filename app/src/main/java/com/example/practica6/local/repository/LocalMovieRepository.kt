package com.example.practica6.local.repository

import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.practica6.Practica6
import com.example.practica6.local.MovieDao
import com.example.practica6.local.model.LocalMovie

class LocalMovieRepository {
    suspend fun saveMovie(localMovie: LocalMovie) {
        val movieDao : MovieDao = Practica6.database.MovieDao()
        movieDao.saveMovie(localMovie)
    }

    suspend fun searchMovie(id: Int): LocalMovie {
        val movieDao = Practica6.database.MovieDao()
        return movieDao.searchMovie(id)
    }

    suspend fun loadFavorites(): MutableList<LocalMovie> {
        val movieDao = Practica6.database.MovieDao()
        return movieDao.loadFavorites()
    }

    suspend fun deleteFavorite(localMovie: LocalMovie) {
        val movieDao = Practica6.database.MovieDao()
        movieDao.deleteMovie(localMovie)
    }

}