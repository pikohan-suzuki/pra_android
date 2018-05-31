package com.example.suzukis.omikujiapp

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class ResultData (@PrimaryKey open var id : Int =0,
        open var result : String =""
    ) : RealmObject()
