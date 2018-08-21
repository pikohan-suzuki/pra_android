package com.example.suzukis.selectpath3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.Buffer
import java.util.*
import java.util.Collections.min
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    var root = mutableListOf<Int>()
    var streetSum = mutableListOf<Int>()
    var streetList1 = mutableListOf<Int>()
    var streetList2 = mutableListOf<Int>()
    var streetFrom = mutableListOf<Int>()
    var numberOfStreet = 0
    var streetLengths = mutableListOf<Int>()
    var destination = 0
    var streetIndex = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationEditText = findViewById<EditText>(R.id.locationEditText)
        val destinationEditText = findViewById<EditText>(R.id.destinationEditText)
        val searchButton = findViewById<Button>(R.id.searchButton)

        //接続リストの読み込み
        var fileName = this.assets.open("test.txt")//ファイルの読み込み
        var fileReader = BufferedReader(InputStreamReader(fileName))
        var str: String?
        var strList: List<String>
        try {
            str = fileReader.readLine()
            while (str != null) {
                strList = str.split(",")
                streetList1.add(strList[0].toInt())
                streetList2.add(strList[1].toInt())
                str = fileReader.readLine()
            }
        } catch (e: Exception) {
        }

        //距離データの読み込み
        fileName = this.assets.open("testLength.txt")//ファイルの読み込み
        fileReader = BufferedReader(InputStreamReader(fileName))
        try {
            str = fileReader.readLine()
            while (str != null) {
                numberOfStreet++
                streetLengths.add(str.toInt())
                str = fileReader.readLine()
            }
        } catch (e: Exception) {
        }

        //インデックスの作成
        var k = 1
        streetIndex.add(0)
        for (i in streetList1.indices) {
            if (streetList1[i] != k) {
                k++
                streetIndex.add(i)
            }
        }

        searchButton.setOnClickListener() {
            val loca: String? = locationEditText.text.toString()
            val dest: String? = destinationEditText.text.toString()
            root.clear()
            streetSum.clear()
            streetFrom.clear()
            for(j in 0 until numberOfStreet) {
                streetSum.add(9999999)
                streetFrom.add(0)
            }
            if (loca != "" && dest != "") {
                root.add(loca!!.toInt())
                destination = dest!!.toInt()
                streetSum[loca.toInt() - 1] = 0
                search()
                root.clear()
                root.add(destination)
                while(root[root.size-1]!=loca.toInt()){
                    root.add(streetFrom[root[root.size -1]-1])
                }
                root = root.asReversed()
                if (root[root.size - 1] == destination) {
                    Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
                    Log.d("最短ルート", root.toString())
                    Log.d("最短距離", streetSum[destination - 1].toString())
                } else {
                    Toast.makeText(this, "failed", Toast.LENGTH_LONG).show()
                }
            } else if (loca == "" && dest == "") {
                Toast.makeText(this, "現在地と目的地を入力してください。", Toast.LENGTH_LONG).show()
            } else if (loca == "") {
                Toast.makeText(this, "現在地を入力してください。", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "目的地を入力してください。", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun search() {
        var i: Int
        var streetEnd: Int
        var minSum: Int
        var minId=0
        while (root[root.size - 1] != destination) {
            i = streetIndex[root[root.size - 1] - 1]
            if (root[root.size - 1] == numberOfStreet) {
                streetEnd = streetList1.size - 1
            } else {
                streetEnd = streetIndex[root[root.size - 1]] - 1
            }
            while (i <= streetEnd) {
                if (!(root.contains(streetList2[i]))) {
                    if(streetSum[streetList2[i] - 1] > streetSum[streetList1[i] - 1] + streetLengths[streetList2[i] - 1]){
                        streetSum[streetList2[i]-1] =streetSum[streetList1[i] - 1] + streetLengths[streetList2[i] - 1]
                        streetFrom[streetList2[i]-1]=streetList1[i]
                    }

                }
                i++
            }
            minSum = 999999
            for (k in streetSum.indices) {
                if(!(root.contains(k+1)) && streetSum[k] < minSum){
                    minSum = streetSum[k]
                    minId =k+1
                }
            }
            root.add(minId)
        }
    }
}