package com.dguardado19.parcial1

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dguardado19.parcial1.adapter.Adapeer
import com.dguardado19.parcial1.database.entities.Equipo
import com.dguardado19.parcial1.models.EquipoViewModel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    lateinit var view: EquipoViewModel
    lateinit var recycler: Adapeer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            startActivity(Intent(this, Main2Activity::class.java))
        }
        recycler = Adapeer(emptyList<Equipo>(), { equipo: Equipo -> (listener(equipo)) })
        recylerxml.adapter = recycler
        recylerxml.layoutManager = LinearLayoutManager(this)

        view = ViewModelProviders.of(this).get(EquipoViewModel::class.java)
        view.AllEquipo.observe(this, Observer { equipo ->
            equipo?.let { recycler.setEquipo(it) }
        })

    }


    fun listener(equipo: Equipo) {
        var content = Bundle()

        content.putParcelable("hay", equipo)

        startActivity(Intent(this, Main3Activity::class.java).putExtra("act3", content))

    }
}


