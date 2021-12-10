package com.example.secundomerlight

import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer


class SecundomerFragment : Fragment() {

    private lateinit var chronometer: Chronometer

    fun convertSecondsToHMmSs(second: Long): String {
        val ms = second %1000
        val seconds = (second / 1000)
        val s = seconds % 60
        val m = seconds / 60 % 60
        val h = seconds / (60 * 60) % 24

        return String.format("%d:%02d:%02d.%03d", h, m, s, ms)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vw_View = inflater.inflate(R.layout.fragment_secundomer, container, false)

        tv_Fst_Time = vw_View.findViewById(R.id.Fst_Time)
        tv_Scnd_Time = vw_View.findViewById(R.id.Secnd_Time)
        tv_Thrd_Time = vw_View.findViewById(R.id.Thrd_Time)
       // tv_Tek_Time = vw_View.findViewById(R.id.Tek_Time)

        Strt_Buttion = vw_View.findViewById(R.id.Strt_Bution)
        Stp_Tek_Buttion = vw_View.findViewById(R.id.Stop_Tek_Bution)
        Stp_Buttion = vw_View.findViewById(R.id.Stop_Bution)

        if (i_Tek_Pos < 1) {
            Stp_Tek_Buttion.hide()
            Stp_Buttion.hide()
            tv_Fst_Time.text = " - "
            tv_Scnd_Time.text = " - "
            tv_Thrd_Time.text = " - "
        } else {
            Strt_Buttion.hide()
            Stp_Tek_Buttion.show()
            Stp_Tek_Buttion.text = i_Tek_Pos.toString()
            Stp_Buttion.show()

        }

        chronometer = vw_View.findViewById(R.id.chronometer)



        // -----------------------------------------------------------------------------
        chronometer.setOnChronometerTickListener {
            val elapsedMillis: Long = (SystemClock.elapsedRealtime() - chronometer.base)

            s_Tek_Time = convertSecondsToHMmSs(elapsedMillis)
            //s_Tek_Time = elapsedMillis.toString()
            //tv_Tek_Time.text = s_Tek_Time

        }

        // -----------------------------------------------------------------------------
        Strt_Buttion.setOnClickListener {

            chronometer.base = SystemClock.elapsedRealtime()
            chronometer.start()

            if (i_Tek_Pos < 1) {
                tv_Fst_Time.text = " - "
                tv_Scnd_Time.text = " - "
                tv_Thrd_Time.text = " - "
            }
            i_Tek_Pos++
            Strt_Buttion.hide()
            Stp_Tek_Buttion.show()
            Stp_Tek_Buttion.text = i_Tek_Pos.toString()
            Stp_Buttion.show()

            chronometer.base = SystemClock.elapsedRealtime()
            chronometer.start()
        }

        // -----------------------------------------------------------------------------
        Stp_Tek_Buttion.setOnClickListener {

            when (i_Tek_Pos) {
                1 -> {
                    //tv_Fst_Time.text=chronometer.getBase().toString()
                    tv_Fst_Time.text = s_Tek_Time
                    s_Tek_Pos[0]=s_Tek_Time
                    i_Tek_Pos++
                    Stp_Tek_Buttion.text = i_Tek_Pos.toString()

                }
                2 -> {
                    //tv_Scnd_Time.text=i_Tek_Pos.toString()
                    tv_Scnd_Time.text = s_Tek_Time
                    s_Tek_Pos[1]=s_Tek_Time
                    i_Tek_Pos++
                    Stp_Tek_Buttion.text = i_Tek_Pos.toString()

                }
                3 -> {
                    //tv_Thrd_Time.text=i_Tek_Pos.toString()
                    tv_Thrd_Time.text = s_Tek_Time
                    s_Tek_Pos[2]=s_Tek_Time
                    i_Tek_Pos = 0
                    Stp_Tek_Buttion.hide()
                    Stp_Buttion.hide()
                    Strt_Buttion.show()
                    chronometer.stop()

                }

            }
        }

        // -----------------------------------------------------------------------------
        Stp_Buttion.setOnClickListener {

            i_Tek_Pos = 0
            Stp_Tek_Buttion.hide()
            Stp_Buttion.hide()
            Strt_Buttion.show()
            tv_Fst_Time.text = " - "
            tv_Scnd_Time.text = " - "
            tv_Thrd_Time.text = " - "
            chronometer.stop()
        }

        return vw_View
    }


}