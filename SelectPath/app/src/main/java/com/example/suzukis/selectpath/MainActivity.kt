package com.example.suzukis.selectpath

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.Buffer
import kotlin.math.sign
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    var directionList = mutableListOf<Int>()
    var minDirectionList = mutableListOf<Int>()
    var minLength: Int = 99999
    val NumberOfStreet = 3
    var streetPath = Array(NumberOfStreet, { Array(NumberOfStreet, { 0 }) })
    val streetLength = Array(NumberOfStreet, { 0 })


    lateinit var locationEditText: EditText
    lateinit var destinationEditText: EditText
    lateinit var searchButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationEditText = findViewById(R.id.location) as EditText
        destinationEditText = findViewById(R.id.destination) as EditText
        searchButton = findViewById(R.id.searchButton) as Button

        val fileName = this.assets.open("test.txt")
        val fileReader = BufferedReader(InputStreamReader(fileName))
        var str: String?
        var strList: List<String>
        var streetNumber1: Int
        var streetNumber2: Int
        try {
            str = fileReader.readLine()
            while (str != null) {
                strList = str.split(",")
                streetNumber1 = strList[0].toInt()
                streetNumber2 = strList[1].toInt()
                streetPath[streetNumber1 - 1][streetNumber2 - 1]++
                str = fileReader.readLine()
            }
        } catch (e: Exception) {
        }

        val fileName2 = this.assets.open("testLength.txt")
        val fileReader2 = BufferedReader(InputStreamReader(fileName2))
        var length: Int?
        var number = 0
        try {
            length = fileReader2.readLine().toInt()
            while (length != null) {
                streetLength[number] = length
                number++
                length = fileReader2.readLine().toInt()
            }
        } catch (e: Exception) {
        }

        searchButton.setOnClickListener() {
            val loca: String? = locationEditText.text.toString()
            val dest: String? = destinationEditText.text.toString()
            if (loca != null && dest != null) {1
                val location: Int = loca.toInt() - 1
                var destination: Int = dest.toInt() - 1
                minDirectionList.clear()
                directionList.add(location)
                searchRoot(destination)
                if(minDirectionList[minDirectionList.size -1] == destination){
                    Toast.makeText(this,"success",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"failed",Toast.LENGTH_LONG).show()
                }

            } else {
                if (loca == null && dest == null) {
                    Toast.makeText(this, "現在地と目的地を入力してください", Toast.LENGTH_LONG).show()
                } else if (loca == null) {
                    Toast.makeText(this, "現在地を入力してください", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "目的地を入力してください", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun searchRoot(destination: Int) {
        var location = directionList[directionList.size -1]
        var i =0
        while(i < NumberOfStreet){
//        for (i in 0 until NumberOfStreet) {
            if (streetPath[location][i] ==1){
                var existFlg  :Boolean= false
                for(j in directionList.indices){
                       if(directionList[j] ==i){
                           existFlg=true
                       }
                }
                if(existFlg == false) {
                    directionList.add(i)
                    if(i == destination){
                        minDirectionList.clear()
                        for(j in directionList.indices) {
                            minDirectionList.add(directionList[j])
                        }
                        return
                    }else{
                        searchRoot(destination)
                        i=directionList[directionList.size -1]
                        directionList.removeAt(directionList.size -1)
                        location = directionList[directionList.size -1]
                        Toast.makeText(this,"aaa",Toast.LENGTH_LONG).show()
                    }
                }
            }
            i++
        }
    }
}
