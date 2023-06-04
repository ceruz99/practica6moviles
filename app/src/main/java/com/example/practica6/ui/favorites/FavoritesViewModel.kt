package com.example.practica6.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica6.local.model.LocalMovie
import com.example.practica6.local.repository.LocalMovieRepository
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {

    private val localMovieRepository = LocalMovieRepository()

    private val _favoritesMovies : MutableLiveData<ArrayList<LocalMovie>> = MutableLiveData()
    val favoritesMovies : LiveData<ArrayList<LocalMovie>> = _favoritesMovies
    fun loadFavorites() {
        viewModelScope.launch{
            val listFavorites = localMovieRepository.loadFavorites()
            _favoritesMovies.postValue(listFavorites as ArrayList<LocalMovie>)
        }
    }

    fun deleteFavorite(localMovie: LocalMovie) {
        viewModelScope.launch {
            localMovieRepository.deleteFavorite(localMovie)
        }
    }

}