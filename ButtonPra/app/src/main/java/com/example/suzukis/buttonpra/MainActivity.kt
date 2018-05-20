package com.example.suzukis.buttonpra

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var resetButton: Button
    lateinit var plusButton: Button
    lateinit var minusButton: Button
    lateinit var countText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resetButton = findViewById(R.id.resetButton)
        plusButton = findViewById(R.id.plusButton)
        minusButton = findViewById(R.id.minusButton)
        countText = findViewById(R.id.countTextView)

        resetButton.setOnClickListener() {
            countText.setText("0")
        }

        plusButton.setOnClickListener() {
            val count: String = countText.text.toString()
            countText.text = (count.toInt() + 1).toString()
        }

        minusButton.setOnClickListener() {
            val count: String = countText.text.toString()
            if (countText.text.equals("0")) {
            } else {
                countText.text = (count.toInt() - 1).toString()
            }
        }
    }
}
