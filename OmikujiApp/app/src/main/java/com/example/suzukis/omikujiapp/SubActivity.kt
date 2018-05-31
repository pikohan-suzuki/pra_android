package com.example.suzukis.omikujiapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import io.realm.Realm
import kotlin.math.absoluteValue

class SubActivity : AppCompatActivity() {

    val mRealm: Realm = Realm.getDefaultInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val randNum = intent.getStringExtra("randNum")
        val resultImageView = findViewById(R.id.resultImageView) as ImageView
        val historyButton = findViewById(R.id.historyButton) as Button
        val againButton = findViewById(R.id.againButton) as Button
        val result = randNum.toInt().absoluteValue % 7
        var resultStr: String =""

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
        Save(resultStr)

        againButton.setOnClickListener() {
            finish()
        }
        historyButton.setOnClickListener(){
            val subIntent = Intent(this,HistryActivity::class.java)
            startActivity(subIntent)
        }
    }

    fun Save(result: String) {
        val maxId: Number? = mRealm.where(ResultData::class.java).max("id")
        val nextId: Int
        if (maxId == null)
            nextId = 0
        else
            nextId = maxId.toInt() + 1
        mRealm.executeTransaction {
            val resultData = mRealm.createObject(ResultData::class.java, nextId)
            resultData.result = result
        }
    }

    fun Read() {

    }
}