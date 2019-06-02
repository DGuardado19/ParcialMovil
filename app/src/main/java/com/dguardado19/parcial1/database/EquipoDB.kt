package com.dguardado19.parcial1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dguardado19.parcial1.database.Dao.equipoDao
import com.dguardado19.parcial1.database.entities.Equipo
import java.security.AccessControlContext

@Database(entities = [Equipo::class],version = 1, exportSchema = false)
abstract class EquipoDB : RoomDatabase(){
    abstract  fun EquipoDao(): equipoDao

    companion object{
        @Volatile
        private var INSTANCE: EquipoDB?=null

        fun getDataBase(
            context: Context
        ):EquipoDB{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EquipoDB::class.java,
                    "equipo_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE=instance
                instance
            }
        }
    }
}