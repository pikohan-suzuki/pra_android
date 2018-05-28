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
        val button = findViewById(R.id.button_main) as Button

        button.setOnClickListener() {
            fragmentManager.beginTransaction().replace(R.id.container, Fragment1.newInstance()).commit()
        }

    }
}
