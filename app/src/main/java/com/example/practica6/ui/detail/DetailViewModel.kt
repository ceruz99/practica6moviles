package com.example.practica6.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica6.local.model.LocalMovie
import com.example.practica6.local.repository.LocalMovieRepository
import com.example.practica6.server.model.Movie
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val localMovieRepository = LocalMovieRepository()

    fun saveMovie(movie: Movie) {
        val localMovie = LocalMovie(id = movie.imdbID.toInt(), name = movie.title, year = movie.year)

        viewModelScope.launch {
            localMovieRepository.saveMovie(localMovie)
        }
    }

}