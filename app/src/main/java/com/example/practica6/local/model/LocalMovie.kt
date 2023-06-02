package com.example.practica6.local.model

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Entity(tableName = "table_movies")

data class LocalMovie (
    @PrimaryKey @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") val name : String?,
    @ColumnInfo(name = "year") val year : String?,
        )