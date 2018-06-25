package com.example.suzukis.omikujiapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.format.DateFormat
import android.widget.Button
import android.widget.ImageView
import io.realm.Realm
import java.util.*
import kotlin.math.absoluteValue

class SubActivity : AppCompatActivity() {

    var mRealm: Realm= Realm.getDefaultInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val randNum = intent.getStringExtra("randNum")
        val resultImageView = findViewById<ImageView>(R.id.resultImageView)
        val historyButton = findViewById<Button>(R.id.historyButton)
        val againButton = findViewById<Button>(R.id.againButton)
        val result = randNum.toInt().absoluteValue % 7
        var resultStr: String = ""

        when (result) {
            0 -> {
                resultImageView.setImageResource(R.drawable.daikyou)
                resultStr = "大凶"
            }
            1 -> {
                resultImageView.setImageResource(R.drawable.kyou)
                resultStr = "凶"
            }
            2 -> {
                resultImageView.setImageResource(R.drawable.suekiti)
                resultStr = "末吉"
            }
            3 -> {
                resultImageView.setImageResource(R.drawable.kiti)
                resultStr = "吉"
            }
            4 -> {
                resultImageView.setImageResource(R.drawable.syoukiti)
                resultStr = "小吉"
            }
            5 -> {
                resultImageView.setImageResource(R.drawable.tyuukiti)
                resultStr = "中吉"
            }
            6 -> {
                resultImageView.setImageResource(R.drawable.daikiti)
                resultStr = "大吉"
            }
        }
        save(resultStr)

        againButton.setOnClickListener() {
            finish()
        }
        historyButton.setOnClickListener {
            val subIntent = Intent(this, HistoryActivity::class.java)
            startActivity(subIntent)
        }
    }

    fun read(): List<ResultData> {
        return mRealm.where(ResultData::class.java).findAll()
    }

    fun save(result: String) {
        val maxId: Number? = mRealm.where(ResultData::class.java).max("id")
        val nextId: Int
        val time:String
        nextId = if (maxId == null)
            0
        else
            maxId.toInt() + 1

        val date = Date()
        time= DateFormat.format("kk:mm:ss", date).toString()

        mRealm.executeTransaction {
            val resultData = mRealm.createObject(ResultData::class.java, nextId)
            resultData.result = result
            resultData.time = time
        }
    }
}