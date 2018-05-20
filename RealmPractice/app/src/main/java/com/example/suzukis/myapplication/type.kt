package com.example.suzukis.myapplication

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class typeData(@PrimaryKey open var id:Int=0,
                    open var typeName:String=""
):RealmObject()