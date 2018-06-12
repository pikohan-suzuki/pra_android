package com.example.suzukis.omikujiapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_history.*

class HistryActivity : AppCompatActivity() {

    lateinit var subAct : SubActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)


        subAct = SubActivity()

        val historyList :List<ResultData> = subAct.Read()
        val showHistoryList = mutableListOf<String>()
        val showTimeList= mutableListOf<String>()

        for( i in  historyList.indices){
            showHistoryList.add(historyList[i].result)
            showTimeList.add(historyList[i].time)
        }

        val resultAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, showHistoryList)
        val timeAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, showTimeList)
        resultListView.adapter = resultAdapter
        timeListView.adapter = timeAdapter

        val returnSubButton = findViewById(R.id.returnSubButton) as Button
        returnSubButton.setOnClickListener{
            finish()
        }
    }
}