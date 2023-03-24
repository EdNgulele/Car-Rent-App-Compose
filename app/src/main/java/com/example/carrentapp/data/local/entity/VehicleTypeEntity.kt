package com.example.carrentapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicle_type_table")
data class VehicleTypeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String
)