package com.example.suzukis.screentransition

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.app.Activity
import android.util.Log
import android.widget.ListView
import android.widget.Toast


class CitiesActivity :AppCompatActivity(){

    override fun onCreate(savedInstances: Bundle?){
        super.onCreate(savedInstances)
        setContentView(R.layout.activity_cities)
        val citiesListView = findViewById(R.id.citiesListView) as ListView
        val returnButton = findViewById(R.id.returnButton) as Button
        val citiesList = intent.getStringArrayListExtra("citiesList")
        val citiesAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,citiesList)

        citiesListView.adapter = citiesAdapter

        returnButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }





}