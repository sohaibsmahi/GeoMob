package com.example.geomob.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "countries")
data class Country(
    @PrimaryKey val ID: String,
    val name: String,
    val drapeau: String,
    val hymne: String,
    var capital:String,
    val surface: String ,
    val population: String,
    val description: String,
    val historique: String,
    val images : String,
    val personnalites: String,
    val ressources: String

)