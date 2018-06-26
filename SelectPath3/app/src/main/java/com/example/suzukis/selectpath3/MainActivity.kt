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
    var sum = 0

    var streetSum = mutableListOf<Int>()
    var streetList1 = mutableListOf<Int>()
    var streetList2 = mutableListOf<Int>()
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
                streetSum[numberOfStreet] = 9999999
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
            if (loca != "" && dest != "") {
                root.add(loca!!.toInt())
                destination = dest!!.toInt()
                search()
                if (root[root.size - 1] == destination) {
                    Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
                    Log.d("最短ルート", root.toString())
                    Log.d("最短距離", sum.toString())
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
        var i = streetIndex[root[root.size - 1]]
        var streetEnd: Int
        var minId = 0
        var minSum = 999999
        while (root[root.size - 1] != destination) {
            if (root[root.size - 1] == numberOfStreet) {
                streetEnd = streetList1.size - 1
            } else {
                streetEnd = streetIndex[root[root.size - 1] + 1] - 1
            }
            while (i <= streetEnd) {
                if (!(root.contains(streetList2[i]))) {
                    streetSum[streetList2[i]] = min(streetSum[streetList2[i]], streetSum[streetList1[i]] + streetLengths[streetList2[i] - 1])
                    if (streetSum[streetList2[i]] < minSum) {
                        minId = streetList2[i]
                        minSum = streetSum[streetList2[i]]
                    }
                }
                i++
            }
            root.add(minId)
            sum+=streetLengths[minId-1]
        }
    }
}

class Stack {
    var elements = mutableListOf<Int>()
    fun push(n: Int) {
        elements.add(n)
    }

    fun pop(): Int {
        val lastElement = elements[elements.size - 1]
        elements.remove(elements.size - 1)
        return lastElement
    }

    fun isEmpty(): Boolean {
        return elements.size == 0
    }
}