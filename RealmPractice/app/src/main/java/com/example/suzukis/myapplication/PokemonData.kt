package com.example.suzukis.myapplication

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class PokemonData(@PrimaryKey open var pokemonId:Int=0,
                    open var pokemonName:String="",
                       open var typeId1: Int=0,
                       open var typeId2: Int =0
):RealmObject()