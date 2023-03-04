package com.example.carrentapp.ui.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Car(
    val brand: String,
    val model: String,
    val costPerDay: Int,
    val logo: Int,
    val transmission: String? = null,
    val fuelType: String? = null,
    val carImages: CarImages,
    val vehicleType: VehicleType? = null,
    val isAvailable: Boolean,
    val location: String? = null,
)
