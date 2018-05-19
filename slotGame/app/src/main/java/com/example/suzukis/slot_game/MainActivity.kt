package com.example.suzukis.slot_game

import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.util.*
import java.util.Calendar.MILLISECOND


class MainActivity : AppCompatActivity() {
    lateinit var numberImageView1: ImageView
    lateinit var numberImageView2: ImageView
    lateinit var numberImageView3: ImageView
    lateinit var stopButton1: Button
    lateinit var stopButton2: Button
    lateinit var stopButton3: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        var slot1: Int = 0
        var slot2: Int = 0
        var slot3: Int = 0
        var slot1Flg = -1
        var slot2Flg = -1
        var slot3Flg = -1
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stopButton1 = findViewById(R.id.stopButton1) as Button
        stopButton2 = findViewById(R.id.stopButton2) as Button
        stopButton3 = findViewById(R.id.stopButton3) as Button
        numberImageView1 = findViewById(R.id.numberImage1) as ImageView
        numberImageView2 = findViewById(R.id.numberImage2) as ImageView
        numberImageView3 = findViewById(R.id.numberImage3) as ImageView





        stopButton1.setOnClickListener() {
            val calendar = Calendar.getInstance()
            val ms = calendar.get(Calendar.MILLISECOND)
            slot1Flg =1
            when (ms % 4) {
                0 -> {
                    numberImageView1.setImageResource(R.drawable.doroid2)
                    slot1 = 0
                }
                1 -> {
                    numberImageView1.setImageResource(R.drawable.number1)
                    slot1 = 1
                }
                2 -> {
                    numberImageView1.setImageResource(R.drawable.number2)
                    slot1 = 2
                }
                3 -> {
                    numberImageView1.setImageResource(R.drawable.number3)
                    slot1 = 3
                }
            }
            if(slot1Flg==1 && slot2Flg==1 && slot3Flg==1){
                answer(slot1,slot2,slot3)
            }
        }
        stopButton2.setOnClickListener() {
            slot2Flg = 1
            val calendar = Calendar.getInstance()
            val ms = calendar.get(Calendar.MILLISECOND)
            when (ms % 4) {
                0 -> {
                    numberImageView2.setImageResource(R.drawable.doroid2)
                    slot2 = 0
                }
                1 -> {
                    numberImageView2.setImageResource(R.drawable.number1)
                    slot2 = 1
                }
                2 -> {
                    numberImageView2.setImageResource(R.drawable.number2)
                    slot2 = 2
                }
                3 -> {
                    numberImageView2.setImageResource(R.drawable.number3)
                    slot2 = 3
                }
            }
            if(slot1Flg==1 && slot2Flg==1 && slot3Flg==1){
                answer(slot1,slot2,slot3)
            }
        }
        stopButton3.setOnClickListener() {
            slot3Flg = 1
            val calendar = Calendar.getInstance()
            val ms = calendar.get(Calendar.MILLISECOND)
            when (ms % 4) {
                0 -> {
                    numberImageView3.setImageResource(R.drawable.doroid2)
                    slot3 = 0
                }
                1 -> {
                    numberImageView3.setImageResource(R.drawable.number1)
                    slot3 = 1
                }
                2 -> {
                    numberImageView3.setImageResource(R.drawable.number2)
                    slot3 = 2
                }
                3 -> {
                    numberImageView3.setImageResource(R.drawable.number3)
                    slot3 = 3
                }
            }
            if(slot1Flg==1 && slot2Flg==1 && slot3Flg==1){
                answer(slot1,slot2,slot3)
            }
        }
    }
    fun answer(slot1 :Int,slot2:Int,slot3:Int){
        if(slot1==0 && slot1==slot2 && slot2==slot3){
            Toast.makeText(this,"大当たり！",Toast.LENGTH_LONG).show()
        }else if(slot1==slot2 && slot2==slot3){
            Toast.makeText(this,"当たり！",Toast.LENGTH_LONG).show()
        }
    }
}
