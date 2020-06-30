package com.example.geomob.data

import androidx.room.*

@Dao
interface CountryDao {
    @Query("Select * from countries")
    fun getCountries():MutableList<Country>

    @Query("Select * from countries Limit 2")
    fun getInitialCountries():MutableList<Country>


    @Query("Select * from countries where id = :id")
    fun getCountry(id:Int):Country

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    fun addCountry(country: Country)
}
