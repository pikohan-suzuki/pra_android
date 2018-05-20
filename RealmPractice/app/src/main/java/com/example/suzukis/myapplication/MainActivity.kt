package com.example.suzukis.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.read
import android.widget.ArrayAdapter
import android.widget.ListView
import io.realm.Realm
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.lang.Math.log
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var typeRealm: Realm
    lateinit var pokemonRealm: Realm
    lateinit var typeIdListView : ListView
    lateinit var typeNameListView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        typeIdListView = findViewById(R.id.typeIdListView)
        typeNameListView = findViewById(R.id.typeNameListView)

        Realm.init(this)
        typeRealm = Realm.getDefaultInstance()
        Realm.init(this)
        pokemonRealm = Realm.getDefaultInstance()


        val dataList: List<typeData> = typeRead()
        val typeIdList =  mutableListOf<Int>()
        val typeNameList = mutableListOf<String>()

        for ( i in dataList.indices){
            typeIdList.add(dataList[i].id)
            typeNameList.add(dataList[i].typeName)
        }
        val typeIdAdapter = ArrayAdapter<Int>(this,android.R.layout.simple_list_item_1,typeIdList)
        val typeNameAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,typeNameList)
        typeIdListView.adapter = typeIdAdapter
        typeNameListView.adapter = typeNameAdapter
    }

    fun typeSave(typeId: Int, typeName: String) {
        typeRealm.executeTransaction {
            var type = typeRealm.createObject(typeData::class.java, typeId)
            type.typeName = typeName
        }
    }

    fun pokemonSave(pokemonId: Int, pokemonName: String, type1: Int, type2: Int) {
        pokemonRealm.executeTransaction {
            val pokemon = pokemonRealm.createObject(pokemonData::class.java, pokemonId)
            pokemon.pokemonName = pokemonName
            pokemon.type1 = type1
            pokemon.type2 = type2
        }
    }


    fun typeRead(): List<typeData> {
        return typeRealm.where(typeData::class.java).findAll()
    }

}