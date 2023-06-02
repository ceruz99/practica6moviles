package com.example.practica6.local


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.practica6.local.model.LocalMovie

@Dao
interface MovieDao {
    @Insert
    suspend fun saveMovie(movie: LocalMovie)

    @Delete
    suspend fun deleteMovie(movie: LocalMovie)
}