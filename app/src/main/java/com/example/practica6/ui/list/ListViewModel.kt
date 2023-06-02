package com.example.practica6.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica6.server.model.BatmanMovies
import com.example.practica6.server.model.Movie
import com.example.practica6.server.repository.MoviesRepository
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    val moviesRepository = MoviesRepository()

    private val  _moviesLoaded : MutableLiveData< List<Movie>> = MutableLiveData()
    val moviesLoaded: LiveData< List<Movie>> = _moviesLoaded
    fun loadMovies() {
        viewModelScope.launch {
            val moviesList : BatmanMovies = moviesRepository.loadMovies()
            _moviesLoaded.postValue(moviesList.movies)
        }
    }

}