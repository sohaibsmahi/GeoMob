package com.example.geomob.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "countries")
data class Country(
    @PrimaryKey val id: Int,
    val description: String,
    val capital:String,
    val drapeau: String,
    val historique: String,
    val hymne: String,
    val name: String,
    val personnalites: String,
    val population: String,
    val ressources: String,
    val surface: String
)