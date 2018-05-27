package com.example.suzukis.realmpractice2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //データベースに登録
        Realm.init(this)
        val mRealm :Realm = Realm.getDefaultInstance()
        val typeIdList = mutableListOf(1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17)
        val typeNameList = mutableListOf("ノーマル","ほのお", "みず","でんき", "くさ","こおり","かくとう","どく","じめん","ひこう","エスパー","むし","いわ","ゴースト","ドラゴン","あく","はがね")
        try {
            for (i in typeIdList.indices) {
                Save(mRealm, typeIdList[i], typeNameList[i])
            }
        }catch (e:Exception){
        }
        //データ読み出し
        val TypeDataList: List<TypeData> = Read(mRealm)
        for (i in TypeDataList.indices) {
            Log.d("result", "typeId:" + TypeDataList[i].typeId + "\ttypeName" + TypeDataList[i].typeName)
        }
        mRealm.close()
    }

    fun Read(mRealm: Realm): List<TypeData> {
        return mRealm.where(TypeData::class.java).findAll()
    }

    fun Save(mRealm: Realm, typeId: Int, typeName: String) {
        mRealm.executeTransaction {
            val type = mRealm.createObject(TypeData::class.java, typeId)
            type.typeName = typeName
        }
    }

}