package com.example.carrentapp.ui.home

import androidx.compose.ui.res.painterResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carrentapp.R
import com.example.carrentapp.ui.data.model.Car
import com.example.carrentapp.ui.data.model.CarImages
import com.example.carrentapp.ui.data.model.CarListState
import com.example.carrentapp.ui.data.model.VehicleType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CarListViewModel : ViewModel() {
    private val _state = MutableStateFlow(CarListState())
    val state: StateFlow<CarListState> get() = _state

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        val cars = listOf(
            Car(
                brand = "BMW",
                model = "M3",
                costPerDay = 100,
                logo = R.drawable.bwm_logo,
                carImages = CarImages(thumbnailResourceId = R.drawable.bmw_thumbnail),
                isAvailable = true
            ),
            Car(
                brand = "Acura",
                model = "...",
                costPerDay = 80,
                logo = R.drawable.acura_logo,
                carImages = CarImages(thumbnailResourceId = R.drawable.acura_thumbnail),
                isAvailable = true
            ),
            Car(
                brand = "Bentley",
                model = "M3",
                costPerDay = 68,
                logo = R.drawable.bwm_logo,
                carImages = CarImages(thumbnailResourceId = R.drawable.bentlye_thumbnail),
                isAvailable = true
            ),

            Car(
                brand = "Audi",
                model = "M3",
                costPerDay = 48,
                logo = R.drawable.audi_logo,
                carImages = CarImages(thumbnailResourceId = R.drawable.audi_thumbnail),
                isAvailable = true
            )
        )

        val vehicleType = VehicleType(type = listOf("Luxury", "Mini Van", "Truck", "Limo"))

        _state.value = CarListState(cars = cars, vehicleTypes = vehicleType.type)
    }
}