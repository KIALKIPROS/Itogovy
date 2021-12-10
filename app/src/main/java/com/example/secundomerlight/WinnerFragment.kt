package com.example.secundomerlight

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class WinnerFragment : Fragment() {

    lateinit var rv_winerRecyclerView: RecyclerView
    lateinit var show_site_buttion: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val vw_View = inflater.inflate(R.layout.fragment_winner, container, false)

        var l_winTime: MutableList<String> = mutableListOf(" - ", " - ", " - ")

        l_winTime[0] = " Winner   : " + s_Tek_Pos[0]
        l_winTime[1] = " 2nd place: " + s_Tek_Pos[1]
        l_winTime[2] = " 3rd plase: " + s_Tek_Pos[2]

        show_site_buttion=vw_View.findViewById(R.id.goto_site_buttion)

        rv_winerRecyclerView = vw_View.findViewById(R.id.winer_Recycler_View)
        rv_winerRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_winerRecyclerView.adapter = WinerAdapter(l_winTime)

        show_site_buttion.setOnClickListener{

            val link= Uri.parse("https://odin.study/ru/Dashboard")
            val intent=Intent(Intent.ACTION_VIEW, link)

            context?.startActivity(intent)
        }



        return vw_View
    }

}