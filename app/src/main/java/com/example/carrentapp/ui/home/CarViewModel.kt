package com.example.carrentapp.ui.home

import androidx.lifecycle.ViewModel
import com.example.carrentapp.ui.data.model.Car
import com.example.carrentapp.ui.data.model.VehicleType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CarViewModel : ViewModel() {

    //TODO add State for car and vehicle Type

    private val _vehicleTypeViewState = MutableStateFlow(
        VehicleType(type = listOf("Luxury", "Mini Van", "Truck", "Limo"))
    )
    val vehicleTypeViewState = _vehicleTypeViewState.asStateFlow()

}