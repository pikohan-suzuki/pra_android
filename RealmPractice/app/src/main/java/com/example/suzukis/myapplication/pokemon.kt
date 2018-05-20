package com.example.suzukis.myapplication

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class pokemonData(@PrimaryKey open var id: Int = 0,
                       open var pokemonName: String = "",
                       open var type1: Int = 0,
                       open var type2: Int = 0
) : RealmObject()