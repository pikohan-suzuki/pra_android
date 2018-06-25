package com.example.suzukis.selectpath2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader


val pathList1 = mutableListOf<Int>()
val pathList2 = mutableListOf<Int>()
val pathLength = mutableListOf<Int>()
val pathIndex = mutableListOf<Int>()

var numberOfStreets =0
var minLength = 9999999                                     //最短経路の長さ
var minRoot = mutableListOf<Int>()       //最短経路のリスト
var lengthSum = 0                                            //経路の差がさ
var root = mutableListOf<Int>()           //経路のリスト
var dest = 0                                 //目的地

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchButton = findViewById<Button>(R.id.search_button)
        val locationEditText = findViewById<EditText>(R.id.location)
        val destinationEditText = findViewById<EditText>(R.id.destination)



        //接続ファイルの読み込み
        var fileName = this.assets.open("str8-5.txt")//ファイルの読み込み
        var fileReader = BufferedReader(InputStreamReader(fileName))
        var str: String?
        var strList: List<String>
        try {
            str = fileReader.readLine()
            while (str != null) {
                strList = str.split(",")
                pathList1.add(strList[0].toInt())
                pathList2.add(strList[1].toInt())
                str = fileReader.readLine()
            }
        } catch (e: Exception) {
        }

        //距離ファイルの読み込み
        fileName = this.assets.open("len8-5.txt")//ファイルの読み込み
        fileReader = BufferedReader(InputStreamReader(fileName))
        try {
            str = fileReader.readLine()
            while (str != null) {
                numberOfStreets++
                pathLength.add(str.toInt())
                str = fileReader.readLine()
            }
        } catch (e: Exception) {
        }

        //インデックスの作成
        pathIndex.add(0)
        var k = pathList1[0]
        for (i in pathList1.indices) {
            if (k != pathList1[i]) {
                pathIndex.add(i)
                k = pathList1[i]
            }
        }

        //検索
        searchButton.setOnClickListener() {
            val loca: String? = locationEditText.text.toString()        //現在地
            val destination: String? = destinationEditText.text.toString()     //目的

            if (loca != "" && destination != "") {
                dest = destination!!.toInt()
                root.add(loca!!.toInt())
                try {
                    search()
                }catch(e: Exception){
                    Log.d("aaaaaaa",root.toString())
                }
                Log.d("最短ルート",minRoot.toString())
                Log.d("最短距離", minLength.toString())
                if(minLength != 9999999){

                    if(minRoot[minRoot.size -1] == dest){
                        Toast.makeText(this,"success",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"failed",Toast.LENGTH_LONG).show()
                    }
                }


            } else if (loca == "" && destination != "") {
                Toast.makeText(this, "現在地と目的地を入力してください。", Toast.LENGTH_LONG).show()
            } else if (loca == "") {
                Toast.makeText(this, "現在地を入力してください。", Toast.LENGTH_LONG).show()
            } else if (destination == "") {
                Toast.makeText(this, "目的地を入力してください。", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "入力エラー", Toast.LENGTH_LONG).show()
            }
        }
    }
}

fun search() {
    var pathEnd :Int
    var i = pathIndex[root[root.size - 1]-1]
    if(root[root.size - 1] == numberOfStreets)  pathEnd= pathList1.size-1
    else pathEnd = pathIndex[root[root.size - 1]]-1
    while(i <= pathEnd){
        if(!(root.contains(pathList2[i]))) {
            root.add(pathList2[i])
            lengthSum += pathLength[pathList2[i] - 1]
            if (pathList2[i] == dest) {
                if (lengthSum < minLength) {
                    minLength = lengthSum
                    minRoot = root.toList().distinct().toMutableList()
                }
                lengthSum -= pathLength[root[root.size - 1] - 1]
                root.removeAt(root.size - 1)
            } else {
                search()
                var k = pathIndex[root[root.size - 2]-1]
                while (pathList2[k] != root[root.size - 1]) {
                    k++
                }
                i = k
                if (root[root.size - 2] == numberOfStreets) pathEnd = pathList1.size - 1
                else pathEnd = pathIndex[root[root.size - 2]] - 1
                lengthSum -= pathLength[root[root.size - 1] - 1]
                root.removeAt(root.size - 1)
            }
        }
        i++
    }
}
