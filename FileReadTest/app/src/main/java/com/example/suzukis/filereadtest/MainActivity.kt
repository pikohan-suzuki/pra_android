package com.example.suzukis.filereadtest

import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.io.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fileName = this.assets.open("type.txt")  //asserts/type.txt　を指定
        var fileReader = BufferedReader(InputStreamReader(fileName))
        var str : String?
        try {
            str = fileReader.readLine() //1行分をstrに代入
            while (str != null ){
                print(str)
                str = fileReader.readLine()
            }
        }catch (e: Resources.NotFoundException){
        }
    }
}
