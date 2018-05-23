package com.example.suzukis.recursionpra

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Recursion(0)
    }

    fun Recursion(j: Int) {
        for (i in 0 until 5) {
            println("i:" + i + "  j:" + j)
            if (count ==0 && i >=3) {
                count++
                Recursion(i)
            }

        }
    }
}
