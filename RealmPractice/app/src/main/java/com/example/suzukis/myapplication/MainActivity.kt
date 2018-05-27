package com.example.suzukis.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.read
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import io.realm.Realm
import java.io.*
import java.lang.Math.log
import kotlin.math.log

class MainActivity : AppCompatActivity() {

//    lateinit var pokemonRealm: Realm
    lateinit var typeIdListView : ListView
    lateinit var typeNameListView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        typeIdListView = findViewById(R.id.typeIdListView)
        typeNameListView = findViewById(R.id.typeNameListView)

        Realm.init(this)
        val typeRealm : Realm = Realm.getDefaultInstance()


        //ファイルの読み込みとデータベースへの追加(type)
        var fileName = this.assets.open("type.txt")
        var fileReader = BufferedReader(InputStreamReader(fileName))
        var str : String?
        var strList :List<String>
        var typeId :Int
        var typeName : String
        str = fileReader.readLine()
        while(str != null) {
            strList = str.split(",")
            typeId = strList[0].toInt()
            typeName = strList[1]
            try {
                TypeSave(typeRealm, typeId, typeName)
            }catch(e:Exception){
            }
            str = fileReader.readLine()
        }

        //ファイルの読み込みとデータベースへの追加(pokemon)
//        fileName = this.assets.open("pokemon.txt")
//        fileReader = BufferedReader(InputStreamReader(fileName))
//        var pokemonId :Int
//        var pokemonName :String
//        var pokemonType1 : Int
//        var pokemonType2 : Int
//        str = fileReader.readLine()
//        while(str != null) {
//            strList = str.split(",")
//            pokemonId = strList[0].toInt()
//            pokemonName = strList[1]
//            pokemonType1 = strList[2].toInt()
//            pokemonType2 = strList[3].toInt()
//            pokemonRealm.executeTransaction() {
//                val pokemon = pokemonRealm.createObject(typeData::class.java,pokemonId)
//                pokemon. = pokemonName
//            }
//        }

        val typeDataList: List<TypeData> = TypeRead(typeRealm)
        val typeIdList =  mutableListOf<Int>()
        val typeNameList = mutableListOf<String>()

        for ( i in typeDataList.indices){
            typeIdList.add(typeDataList[i].typeId)
            typeNameList.add(typeDataList[i].typeName)
        }
        val typeIdAdapter = ArrayAdapter<Int>(this,android.R.layout.simple_list_item_1,typeIdList)
        val typeNameAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,typeNameList)
        typeIdListView.adapter = typeIdAdapter
        typeNameListView.adapter = typeNameAdapter
    }

    fun TypeRead(typeRealm : Realm): List<TypeData> {
        return typeRealm.where(TypeData::class.java).findAll()
    }
    fun TypeSave(typeRealm: Realm,typeId:Int,typeName:String){
        typeRealm.executeTransaction() {
            val type = typeRealm.createObject(TypeData::class.java,typeId)
            Log.d("aaaaaa","TypeId" + typeId )
            type.typeName = typeName
        }
    }
}