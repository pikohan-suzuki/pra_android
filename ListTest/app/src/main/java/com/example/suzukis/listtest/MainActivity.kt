package com.example.suzukis.listtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testList = listOf<Int>(1,2,3,4,5,6,7,8,9,10)
        println(testList + testList.size)
        println(testList.dropLast(2) + "\n" +testList.size)
        println(testList.drop(2) + "\n" + testList.size)

        var testMutableList = mutableListOf(1,2,3,4,5,6,7,8,9,10)
        testMutableList.remove(10)
        println(testMutableList + testMutableList.size)
        testMutableList.removeAll{it <=5}
        println(testMutableList + testMutableList.size)
    }
}
