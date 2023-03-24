package com.example.carrentapp.ui.data.model

data class CarListState(
    val cars: List<Car> = emptyList(),
    val vehicleTypes: List<String> = emptyList()
)