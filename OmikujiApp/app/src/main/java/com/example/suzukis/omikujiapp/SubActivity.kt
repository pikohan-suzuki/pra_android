package com.example.suzukis.omikujiapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import kotlin.math.absoluteValue

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val randNum = intent.getStringExtra("randNum")
        val resultImageView = findViewById(R.id.resultImageView) as ImageView
        val historyButton = findViewById(R.id.historyButton) as Button
        val againButton = findViewById(R.id.againButton) as Button
        println(randNum)
        when (randNum.toInt().absoluteValue % 7) {
            0 ->
                resultImageView.setImageResource(R.drawable.daikyou)
            1 ->
                resultImageView.setImageResource(R.drawable.kyou)
            2 ->
                resultImageView.setImageResource(R.drawable.suekiti)
            3 ->
                resultImageView.setImageResource(R.drawable.kiti)
            4 ->
                resultImageView.setImageResource(R.drawable.syoukiti)
            5 ->
                resultImageView.setImageResource(R.drawable.tyuukiti)
            6 ->
                resultImageView.setImageResource(R.drawable.daikiti)
        }

        againButton.setOnClickListener(){
            finish()
        }
    }
}