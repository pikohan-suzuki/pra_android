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
        val mRealm = Realm.getDefaultInstance()
        val typeIdList = mutableListOf(1, 2, 3)
        val typeNameList = mutableListOf("ほのお", "みず", "くさ")
        for (i in typeIdList.indices) {
            Save(mRealm, typeIdList[i], typeNameList[i])
        }

        //データ読み出し
        val TypeDataList: List<TypeData> = Read(mRealm)
        for (i in TypeDataList.indices) {
            Log.d("result", "typeId:" + TypeDataList[i].typeId + "\ttypeName" + TypeDataList[i].typeName)
        }
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