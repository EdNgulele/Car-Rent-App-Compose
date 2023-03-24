package com.example.carrentapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.carrentapp.data.local.entity.VehicleTypeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleTypeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vehicleType: VehicleTypeEntity)

    @Query("SELECT * FROM vehicle_type_table")
    fun getAllVehicleTypes(): Flow<List<VehicleTypeEntity>>

    @Query("SELECT COUNT(*) FROM vehicle_type_table")
    suspend fun getVehicleTypeCount(): Int
}