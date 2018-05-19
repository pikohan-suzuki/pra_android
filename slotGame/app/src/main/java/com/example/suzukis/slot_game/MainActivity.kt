package com.example.suzukis.slot_game

import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.Calendar.MILLISECOND

class MainActivity : AppCompatActivity() {
    lateinit var numberImageView1: ImageView
    lateinit var numberImageView2: ImageView
    lateinit var numberImageView3: ImageView
    lateinit var stopButton1: Button
    lateinit var stopButton2: Button
    lateinit var stopButton3: Button
    lateinit var resetButton: Button

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
        resetButton = findViewById(R.id.resetButton) as Button

        stopButton1.setOnClickListener() {
            slot1Flg =1
            slot1=setImage(slot1,numberImageView1,stopButton1)
            if(slot1Flg==1 && slot2Flg==1 && slot3Flg==1){
                answer(slot1,slot2,slot3)
            }
        }
        stopButton2.setOnClickListener() {
            slot2Flg = 1
            slot2=setImage(slot2,numberImageView2,stopButton2)
            if(slot1Flg==1 && slot2Flg==1 && slot3Flg==1){
                answer(slot1,slot2,slot3)
            }
        }
        stopButton3.setOnClickListener() {
            slot3Flg = 1
            slot3=setImage(slot3,numberImageView3,stopButton3)
            if(slot1Flg==1 && slot2Flg==1 && slot3Flg==1){
                answer(slot1,slot2,slot3)
            }
        }
        resetButton.setOnClickListener(){
            numberImageView1.setImageResource(R.drawable.doroid)
            numberImageView2.setImageResource(R.drawable.doroid)
            numberImageView3.setImageResource(R.drawable.doroid)
            stopButton1.setVisibility(View.VISIBLE)
            stopButton2.setVisibility(View.VISIBLE)
            stopButton3.setVisibility(View.VISIBLE)
            slot1=0
            slot2=0
            slot3=0
            slot1Flg=-1
            slot2Flg=-1
            slot3Flg=-1
            resetButton.setVisibility(View.INVISIBLE)
        }
    }

    fun answer(slot1 :Int,slot2:Int,slot3:Int){
        if(slot1==0 && slot1==slot2 && slot2==slot3){
            Toast.makeText(this,"大当たり！",Toast.LENGTH_LONG).show()
        }else if(slot1==slot2 && slot2==slot3){
            Toast.makeText(this,"当たり！",Toast.LENGTH_LONG).show()
        }
        resetButton.setVisibility(View.VISIBLE)
    }

    fun setImage( slot : Int,numberImage : ImageView,stopButton : Button) : Int{
        val calendar = Calendar.getInstance()
        val ms = calendar.get(Calendar.MILLISECOND)
        var slotSub = slot
        when (ms % 4) {
            0 -> {
                numberImage.setImageResource(R.drawable.doroid2)
                slotSub = 0
            }
            1 -> {
                numberImage.setImageResource(R.drawable.number1)
                slotSub = 1
            }
            2 -> {
                numberImage.setImageResource(R.drawable.number2)
                slotSub = 2
            }
            3 -> {
                numberImage.setImageResource(R.drawable.number3)
                slotSub = 3
            }
        }
        stopButton.setVisibility(View.INVISIBLE)
        return slotSub
    }
}
