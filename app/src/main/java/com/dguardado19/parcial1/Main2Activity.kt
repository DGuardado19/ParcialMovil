package com.dguardado19.parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProviders
import com.dguardado19.parcial1.adapter.Adapeer
import com.dguardado19.parcial1.database.entities.Equipo
import com.dguardado19.parcial1.models.EquipoViewModel
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    lateinit var  view: EquipoViewModel
    lateinit var recycler: Adapeer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        view= ViewModelProviders.of(this).get(EquipoViewModel::class.java)

        btnguardar.setOnClickListener {
            view.insert(Equipo(ingresarnombreteamA.text.toString(), ingresarnombreteamB.text.toString(),equipo1contador.text.toString().toInt(), contadorequipo2.text.toString().toInt(),
                fechadeljuego.text.toString(), horadeljuego.text.toString()))
            onBackPressed()

        }
        equipo1contador.text=view.punto1.toString()
        contadorequipo2.text=view.punto2.toString()
    }
    fun sumarBoton(vista: View){
        when(vista){
            btnequipo1 ->{
                view.punto1+=1
            }
            btn2Equipo1->{
                view.punto1+=2
            }
            btn3Equipo1->{
                view.punto1+=3
            }
            btnEquipo2->{
                view.punto2+=1
            }
            btn2Equipo2->{
                view.punto2+=2
            }
            btn3Equipo2->{
                view.punto2+=3
            }
        }

        equipo1contador.text=view.punto1.toString()
        contadorequipo2.text=view.punto2.toString()
    }
}


