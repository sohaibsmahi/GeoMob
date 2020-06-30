package com.example.geomob

import android.content.Intent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geomob.data.AppDatabase
import com.example.geomob.data.Country
import kotlinx.android.synthetic.main.activity_countries.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CountriesActivity : AppCompatActivity(), ListAdapter.OnClickListner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)
        rv_countries.layoutManager = LinearLayoutManager(this)
        val dbDao = AppDatabase.invoke(this).getCountryDao()

        doAsync {

            val countries = dbDao.getCountries()

            Log.e("Countries", countries.toString())

            uiThread {

                if (countries != null) refresh(countries)
            }

        }
    }

    override fun onResume() {

        val dbDao = AppDatabase.invoke(this).getCountryDao()

        doAsync {

            val countries = dbDao.getCountries()

            uiThread {

                if(countries!=null) refresh(countries)
            }

        }

        super.onResume()

    }

    private fun refresh(countries : MutableList<Country>){
        rv_countries.adapter = ListAdapter(this,this , countries)
    }

    override fun onItemClick(country: Country, p1: Int) {

        val intent = Intent(this, CountryDetailActivity::class.java)

        intent.putExtra("country_id",country.ID)
        intent.putExtra("name",country.name)
        intent.putExtra("drapeau",country.drapeau)
        intent.putExtra("description",country.description)
        intent.putExtra("historique",country.historique)
        intent.putExtra("capital",country.capital)
        intent.putExtra("hymne",country.hymne)
        intent.putExtra("personnalites",country.personnalites)
        intent.putExtra("population",country.population)
        intent.putExtra("ressources",country.ressources)
        intent.putExtra("surface",country.surface)
        intent.putExtra("images" ,country.images)

        startActivity(intent)

    }


}