package com.dguardado19.parcial1.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.dguardado19.parcial1.database.EquipoDB
import com.dguardado19.parcial1.database.Repository.equipoRepository
import com.dguardado19.parcial1.database.entities.Equipo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EquipoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: equipoRepository
    val AllEquipo: LiveData<List<Equipo>>

    init {
        val EquipoDao = EquipoDB.getDataBase(application).EquipoDao()
        repository= equipoRepository(EquipoDao)
        AllEquipo= repository.getAllEquipo()
    }

    fun insert (equipo: Equipo)= viewModelScope.launch(Dispatchers.IO) {
        repository.insertEquipo()
    }
}