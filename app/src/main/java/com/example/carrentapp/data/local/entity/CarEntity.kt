package com.example.carrentapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car_table")
data class CarEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val brand: String,
    val model: String,
    val costPerDay: Int,
    val logo: Int,
    val thumbnailResourceId: Int,
    val isAvailable: Boolean
)