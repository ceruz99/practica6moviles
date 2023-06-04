package com.example.practica6.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica6.local.model.LocalMovie
import com.example.practica6.local.repository.LocalMovieRepository
import com.example.practica6.server.model.Movie
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val localMovieRepository = LocalMovieRepository()

    private val _isMovieSaved : MutableLiveData<Boolean> = MutableLiveData()
    val isMovieSaved: LiveData<Boolean> = _isMovieSaved

    fun saveMovie(movie: Movie) {

        val localMovie = LocalMovie(id = movie.imdbID.substring(2,9).toInt(), name = movie.title, year = movie.year, poster = movie.poster)

        viewModelScope.launch {
            localMovieRepository.saveMovie(localMovie)
        }
    }

    fun searchMovie(id: Int) {
        var movieFavorite = false
        viewModelScope.launch {
            val localMovie = localMovieRepository.searchMovie(id)
            if (localMovie != null)
                movieFavorite = true
            _isMovieSaved.postValue(movieFavorite)
        }
    }

}