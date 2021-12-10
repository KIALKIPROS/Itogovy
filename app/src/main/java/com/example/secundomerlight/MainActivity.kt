package com.example.secundomerlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

//==========================================================================================
// --- Глобальные переменные ---------------------------------------------------------------
//==========================================================================================

public var i_Tek_Pos = 0                       // --- Текущая позиция -----------------------------

// --- Текущая позиция текст ---------------------------------------------------------------
public var s_Tek_Pos: MutableList<String> = mutableListOf<String>("0:00:00", "0:00:00", "0:00:00")

public var s_Tek_Time = "0:00:00"              // --- Текущее время -------------------------------

public lateinit var Strt_Buttion: ExtendedFloatingActionButton
public lateinit var Stp_Buttion: ExtendedFloatingActionButton
public lateinit var Stp_Tek_Buttion: ExtendedFloatingActionButton

public lateinit var tv_Fst_Time: TextView
public lateinit var tv_Scnd_Time: TextView
public lateinit var tv_Thrd_Time: TextView
public lateinit var tv_Tek_Time: TextView


private const val LAST_MENU_SELECT = "item"

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.menu_bottom)

        bottomNavigationView.setOnItemSelectedListener { item ->

            var fragment: Fragment? = null

            when (item.itemId) {
                R.id.secundomer -> {
                    fragment = SecundomerFragment()
                }
                R.id.winer -> {
                    fragment = WinnerFragment()
                }
            }
            replaceFragment(fragment!!)
            true
        }

        bottomNavigationView.selectedItemId = savedInstanceState?.getInt(
            LAST_MENU_SELECT) ?: R.id.secundomer

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(LAST_MENU_SELECT, bottomNavigationView.selectedItemId)
    }



    fun replaceFragment (fragment: Fragment) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment, fragment)
            .commit()
    }

}