package com.example.practica6

import android.app.Application
import androidx.room.Room
import com.example.practica6.local.MovieDataBase

class Practica6 : Application(){
    companion object{
        lateinit var database: MovieDataBase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, MovieDataBase::class.java,"open_mdb").build()

    }
}