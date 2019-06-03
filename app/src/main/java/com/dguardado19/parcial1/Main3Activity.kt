package com.dguardado19.parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.dguardado19.parcial1.database.entities.Equipo
import com.dguardado19.parcial1.models.EquipoViewModel
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {
    lateinit var view: EquipoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val mostrar: Bundle = this.intent.extras.getBundle("act3")
        var equipo: Equipo = mostrar.getParcelable("hay")

        view = ViewModelProviders.of(this).get(EquipoViewModel::class.java)
        tv_name.text = "Score equipo  " + equipo.equipo1 + " :  " + equipo.score1
        tv_tipo.text = "Score equipo  " + equipo.equipo2 + " :  " + equipo.score2
        tv_weight.text = "Hora del juego :" + equipo.hora
        tv_height.text = "Fecha del juego :" + equipo.fecha

        if (equipo.score1.toString().toInt() > equipo.score2.toString().toInt()) {
            tv_base.text = "Ganador : " + equipo.equipo1}
            else{
                tv_base.text = "Ganador : " + equipo.equipo2
            }
        if (equipo.score1.toString().toInt() == equipo.score2.toString().toInt()){
            tv_base.text = "Ganador : EMPATE"
        }

    }
}
