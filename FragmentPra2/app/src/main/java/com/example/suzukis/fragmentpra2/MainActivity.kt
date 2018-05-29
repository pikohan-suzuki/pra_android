package com.example.suzukis.fragmentpra2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = getFragmentManager()
        val changeButton = findViewById(R.id.button_main) as Button
        val AButton = findViewById(R.id.buttonA) as Button
        val BButton = findViewById(R.id.buttonB) as Button
        val CButton = findViewById(R.id.buttonC) as Button



        val aMutableList : MutableList<String>
        val aList : List<String>
        val bArray : Array<String>


        changeButton.setOnClickListener() {
            fragmentManager.beginTransaction().replace(R.id.container, Fragment1.newInstance()).commit()
        }
        AButton.setOnClickListener(){
            fragmentManager.beginTransaction().replace(R.id.container,Fragment2.newInstance()).commit()
        }
        BButton.setOnClickListener(){
            fragmentManager.beginTransaction().replace(R.id.container,Fragment3.newInstance()).commit()
        }
        CButton.setOnClickListener(){
            fragmentManager.beginTransaction().replace(R.id.container,Fragment1.newInstance()).commit()
        }
    }
}
