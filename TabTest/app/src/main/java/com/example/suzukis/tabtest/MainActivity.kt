package com.example.suzukis.tabtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabItem
import android.support.design.widget.TabLayout
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contentsListView = findViewById(R.id.contentsListView) as ListView
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)


//        tabLayout.addTab(tabLayout.newTab().setText("トップ"))
//        tabLayout.addTab(tabLayout.newTab().setText("モンスター"))
//        tabLayout.addTab(tabLayout.newTab().setText("わざ"))
//        tabLayout.addTab(tabLayout.newTab().setText("タイプ"))
//        tabLayout.addTab(tabLayout.newTab().setText("外部サイト"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                Log.d("myTag", "onTabSelebted")
                when (tabLayout.selectedTabPosition) {

                    0 -> {
                        Log.d("myTag", "トップ")
                    }
                    1 -> {
                        Log.d("myTag", "モンスター")
                    }
                    2 -> {
                        Log.d("myTag", "わざ")
                    }
                    3 ->{
                        Log.d("myTag", "タイプ")
                    }
                    4->{
                        Log.d("myTag", "外部サイト")
                    }
                }

            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("myTag", "onTabUnselected")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("myTag", "onTabReselected")
            }
        })

        val contentsArray = arrayOf("モンスター","わざ","タイプ","外部サイト","","","","","","","","")
        val contentsAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contentsArray)
        contentsListView.adapter = contentsAdapter
    }
}
