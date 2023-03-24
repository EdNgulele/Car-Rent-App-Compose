package com.example.carrentapp.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrentapp.data.local.entity.CarEntity
import com.example.carrentapp.data.local.entity.VehicleTypeEntity
import com.example.carrentapp.data.local.repository.CarRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class CarListViewModel(private val repository: CarRepository) : ViewModel() {
    private val _allCars = MutableStateFlow<List<CarEntity>>(emptyList())
    val allCars: StateFlow<List<CarEntity>> = _allCars

    private val _allVehicleTypes = MutableStateFlow<List<VehicleTypeEntity>>(emptyList())
    val allVehicleTypes: StateFlow<List<VehicleTypeEntity>> = _allVehicleTypes


    init {
        viewModelScope.launch {
            repository.allCars.collect { cars ->
                _allCars.value = cars
            }
        }

        viewModelScope.launch {
            repository.allVehicleTypes.collect { vehicleTypes ->
                _allVehicleTypes.value = vehicleTypes
            }
        }
    }



    fun insert(car: CarEntity) = viewModelScope.launch {
        repository.insert(car)
    }
}