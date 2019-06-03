package com.dguardado19.parcial1.adapter

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import com.dguardado19.parcial1.R
import com.dguardado19.parcial1.database.entities.Equipo
import kotlinx.android.synthetic.main.diseniorecycler.view.*

class Adapeer(var equipo: List<Equipo>, var clickListener: (Equipo) -> Unit) :
    RecyclerView.Adapter<Adapeer.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapeer.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.diseniorecycler, parent,false))
    }

    override fun getItemCount(): Int = equipo.size

    internal fun setEquipo(equipo: List<Equipo>){
        this.equipo= equipo
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind(equipo[position], clickListener)

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun onBind(equipo: Equipo, clickListener: (Equipo) -> Unit) {
            itemView.nombresjugadores.text= equipo.equipo1 + "     vs     "+ equipo.equipo2
            itemView.mostrarScore.text = "     Score "+ equipo.equipo1 + ": " + equipo.score1.toString() + "            Score " + equipo.equipo2 +  ": "+ equipo.score2.toString()
            itemView.linearboton.setOnClickListener {
                clickListener(equipo)
            }

        }

    }

}