package com.abc.swapiclient.framework.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abc.swapiclient.framework.local.models.Planet

interface PlanetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlanet(planet: Planet)

    @Query("SELECT * FROM Planet")
    fun getAllPlanets(): List<Planet>

    @Query("SELECT * FROM Planet WHERE id=:id")
    fun getPlanetById(id: Int): Planet
}