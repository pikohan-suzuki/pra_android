package com.example.suzukis.omikujiapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import io.realm.Realm
import java.util.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Realm.init(this)
        val rand = Random()
        var randNum = rand.nextInt()
        val shuffleButton = findViewById(R.id.shuffleButton) as Button
        val drawButton = findViewById(R.id.drawButton) as Button
        val intent = Intent(this,SubActivity::class.java)

        shuffleButton.setOnClickListener(){
            randNum = rand.nextInt()
            val toast = Toast.makeText(this,"中身を混ぜました。",Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP,0,200)
            toast.show()
        }

        drawButton.setOnClickListener(){
            intent.putExtra("randNum",randNum.toString())
            startActivity(intent)
            randNum=rand.nextInt()
        }
    }
}
