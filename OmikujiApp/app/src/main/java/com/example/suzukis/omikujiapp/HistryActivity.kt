package com.example.suzukis.omikujiapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import io.realm.Realm

class HistryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val returnSubButton = findViewById(R.id.returnSubButton) as Button

        returnSubButton.setOnClickListener{
            finish()
        }
    }
}