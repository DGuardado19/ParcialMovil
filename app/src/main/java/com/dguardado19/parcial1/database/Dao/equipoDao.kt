package com.dguardado19.parcial1.database.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dguardado19.parcial1.database.entities.Equipo

@Dao
interface equipoDao  {

    @Query("SELECT * FROM equipo_table")
    fun getAll():LiveData<List<Equipo>>

    @Insert
    suspend fun Insert(equipo:Equipo)
}