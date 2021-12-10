package com.example.secundomerlight

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WinerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    private val winerTextView:TextView = itemView.findViewById(R.id.winer_text_view)

    fun bind(time:String){

        winerTextView.text = time

    }
}