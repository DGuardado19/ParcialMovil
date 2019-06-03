package com.dguardado19.parcial1.database.Repository

import androidx.lifecycle.LiveData
import com.dguardado19.parcial1.database.Dao.equipoDao
import com.dguardado19.parcial1.database.entities.Equipo

class equipoRepository(
    private val Equipo: equipoDao) {


    fun getAllEquipo(): LiveData<List<Equipo>> = Equipo.getAll()
    suspend fun insertEquipo(equipo: Equipo) = Equipo.Insert(equipo)

}
