package com.example.secundomerlight

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WinerAdapter(private val winerTimes: List<String>) : RecyclerView.Adapter<WinerViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WinerViewHolder {

        val li_itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.winner_list_item, parent, false)

        return WinerViewHolder(li_itemView)

    }

    override fun onBindViewHolder(holder: WinerViewHolder, position: Int) {

        val name = winerTimes[position]

        holder.bind(name)
    }

    override fun getItemCount(): Int {

        return winerTimes.size
    }
}