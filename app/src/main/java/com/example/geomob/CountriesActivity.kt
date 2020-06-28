package com.example.geomob

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.geomob.data.Country

class CountriesActivity : AppCompatActivity(), ListAdapter.OnClickListner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)
    }

    override fun onItemClick(country: Country, p1: Int) {
        val intent = Intent(this,CountryDetailActivity::class.java)
        intent.putExtra("country_id",country.id)
        intent.putExtra("name",country.name)
        intent.putExtra("flag",country.drapeau)
        intent.putExtra("description",country.description)
        intent.putExtra("history",country.historique)
        intent.putExtra("capital",country.capital)
        intent.putExtra("hymne",country.hymne)
        intent.putExtra("personnalités",country.personnalites)
        intent.putExtra("population",country.population)
        intent.putExtra("ressources",country.ressources)
        intent.putExtra("surface",country.surface)
        startActivity(intent)

    }


}