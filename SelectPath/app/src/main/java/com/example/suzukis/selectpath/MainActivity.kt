package com.example.suzukis.selectpath

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.Buffer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fileName = this.assets.open("str8-1.txt")
        var fileReader = BufferedReader(InputStreamReader(fileName))

        val NumberOfStreet = 52
        var str: String?
        var strList :List<String>
        var streetPath = Array(NumberOfStreet,{Array(NumberOfStreet,{0})})
        var streetNumber1: Int
        var streetNumber2: Int
        try {
            str = fileReader.readLine()
            while (str != null) {
                strList = str.split(",")
                streetNumber1 = strList[0].toInt()
                streetNumber2 = strList[1].toInt()
                streetPath[streetNumber1-1][streetNumber2-1]++
                str = fileReader.readLine()
            }
        } catch (e: Exception) {
        }

        val fileName2 = this.assets.open("str8-1.txt")
        val fileReader2 = BufferedReader(InputStreamReader(fileName))
        val streetLength = Array(NumberOfStreet,{0})
        var length :Int?
        var number =1
        try{
            length = fileReader2.readLine().toInt()
            while(length!= null){
                streetLength[number-1] =length
                length = fileReader2.readLine().toInt()
            }
        }catch (e:Exception){
        }
    }
}
