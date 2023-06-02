package com.example.practica6.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practica6.local.model.LocalMovie

@Database(entities = [LocalMovie::class],version = 1)
abstract class MovieDataBase: RoomDatabase() {
    abstract fun MovieDao(): MovieDao
}