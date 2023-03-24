package com.example.carrentapp.data.local.repository

import android.content.Context
import com.example.carrentapp.R
import com.example.carrentapp.data.local.AppDatabase
import com.example.carrentapp.data.local.dao.CarDao
import com.example.carrentapp.data.local.dao.VehicleTypeDao
import com.example.carrentapp.data.local.entity.CarEntity
import com.example.carrentapp.data.local.entity.VehicleTypeEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CarRepository(context: Context) {
    private val carDao: CarDao
    private val vehicleTypeDao: VehicleTypeDao


    val allCars: Flow<List<CarEntity>>
    val allVehicleTypes: Flow<List<VehicleTypeEntity>>


    init {
        val database = AppDatabase.getDatabase(context)
        carDao = database.carDao()
        vehicleTypeDao = database.vehicleTypeDao()
        allCars = carDao.getAllCars()
        allVehicleTypes = vehicleTypeDao.getAllVehicleTypes()
        initializeData()
        initializeVehicleTypes()
    }

    private fun initializeData() {
        CoroutineScope(Dispatchers.IO).launch {
            if (carDao.getCarCount() == 0) {
                val cars = listOf(
                    CarEntity(
                        brand = "BMW",
                        model = "M3",
                        costPerDay = 100,
                        logo = R.drawable.bwm_logo,
                        thumbnailResourceId = R.drawable.bmw_thumbnail,
                        isAvailable = true
                    ),
                    CarEntity(
                        brand = "Acura",
                        model = "...",
                        costPerDay = 80,
                        logo = R.drawable.acura_logo,
                        thumbnailResourceId = R.drawable.acura_thumbnail,
                        isAvailable = true
                    ),
                    CarEntity(
                        brand = "Bentley",
                        model = "M3",
                        costPerDay = 68,
                        logo = R.drawable.bwm_logo,
                        thumbnailResourceId = R.drawable.bentlye_thumbnail,
                        isAvailable = true
                    ),

                    CarEntity(
                        brand = "Audi",
                        model = "M3",
                        costPerDay = 48,
                        logo = R.drawable.audi_logo,
                        thumbnailResourceId = R.drawable.audi_thumbnail,
                        isAvailable = true
                    )
                )
                cars.forEach { car ->
                    carDao.insert(car)
                }
            }
        }
    }

    private fun initializeVehicleTypes() {
        CoroutineScope(Dispatchers.IO).launch {
            if (vehicleTypeDao.getVehicleTypeCount() == 0) {
                val vehicleTypes = listOf("Luxury", "Mini Van", "Truck", "Limo")
                vehicleTypes.forEach { type ->
                    vehicleTypeDao.insert(VehicleTypeEntity(type = type))
                }
            }
        }
    }


    suspend fun insert(car: CarEntity) {
        carDao.insert(car)
    }

}
