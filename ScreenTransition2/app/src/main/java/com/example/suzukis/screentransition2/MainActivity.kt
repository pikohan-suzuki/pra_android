package com.example.suzukis.screentransition2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreenMain()
    }
    fun setScreenMain() {
        setContentView(R.layout.activity_main)
        val moveSubButton = findViewById(R.id.moveToSubButton) as Button
        moveSubButton.setOnClickListener(){
            setScreenSub()
        }
    }

    fun setScreenSub(){
        setContentView(R.layout.activity_sub)
        val moveMainButton = findViewById(R.id.moveToMainButton) as Button
        moveMainButton.setOnClickListener(){
            setScreenMain()
        }
    }
}
