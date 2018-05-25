package com.example.suzukis.screentransition

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_cities.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryListView = findViewById(R.id.countryListView) as ListView
        val countryList = arrayListOf("JPN", "USA", "GBR", "FRA", "ITA", "DEU", "RUS")
        val JPNList = arrayListOf("Tokyo", "Osaka", "Nagoya", "Fukuoka")
        val USAList = arrayListOf("Los Angels", "WashingtonD.C", "California", "Houston")
        val GBRList = arrayListOf("London", "Dover", "Gibraltar")
        val FRAList = arrayListOf("Paris")
        val ITAList = arrayListOf("Roma")
        val DEUList = arrayListOf("Berlin")
        val RUSList = arrayListOf("Leningrad", "Kiev", "Moscow", "Vladivostok")

        lateinit var citiesList: ArrayList<String>


        val countryAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryList)
        countryListView.adapter = countryAdapter

        countryListView.setOnItemClickListener { parent, view, position, id ->

            when (position) {

                0 -> {
                    citiesList = JPNList
                }
                1 -> {
                    citiesList = USAList
                }
                2 -> {
                    citiesList = GBRList
                }
                3 -> {
                    citiesList = FRAList
                }
                4 -> {
                    citiesList = ITAList
                }
                5 -> {
                    citiesList = DEUList
                }
                6 -> {
                    citiesList = RUSList
                }
            }
            val intent = Intent(this, CitiesActivity::class.java)
            intent.putExtra("citiesList", citiesList)
            startActivity(intent)
        }
    }
}
