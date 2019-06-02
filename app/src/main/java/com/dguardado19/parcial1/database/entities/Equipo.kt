package com.dguardado19.parcial1.database.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equipo_table")
data class Equipo(
    @ColumnInfo(name = "equipo1") val equipo1 : String,
    @ColumnInfo(name = "equipo2") val equipo2: String,
    @ColumnInfo(name = "score1") val score1: Int,
    @ColumnInfo(name = "score2") val score2: Int,
    @ColumnInfo(name = "fecha") val fecha: String,
    @ColumnInfo(name = "hora") val hora: String
):Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
        id = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(equipo1)
        parcel.writeString(equipo2)
        parcel.writeInt(score1)
        parcel.writeInt(score2)
        parcel.writeString(fecha)
        parcel.writeString(hora)
        parcel.writeLong(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Equipo> {
        override fun createFromParcel(parcel: Parcel): Equipo {
            return Equipo(parcel)
        }

        override fun newArray(size: Int): Array<Equipo?> {
            return arrayOfNulls(size)
        }
    }

}
