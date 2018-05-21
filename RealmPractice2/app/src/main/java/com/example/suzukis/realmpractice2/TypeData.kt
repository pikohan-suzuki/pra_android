package com.example.suzukis.realmpractice2

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class TypeData(@PrimaryKey open var typeId: Int = 0,
                    open var typeName: String = ""
) : RealmObject()
