package com.example.geomob

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import  com.example.geomob.data.AppDatabase
import com.example.geomob.data.Country
import com.example.geomob.data.CountryDao
import com.example.geomob.data.Images
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_countries.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.rv_countries
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() , ListAdapter.OnClickListner {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_countries.layoutManager = LinearLayoutManager(this)
        val dbDao = AppDatabase.invoke(this).getCountryDao()

        doAsync {

            val countries = dbDao.getInitialCountries()

            Log.e("Countries", countries.toString())

            uiThread {

                if (countries != null) refresh(countries)
            }

        }

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = preferences.edit()

         val filled = preferences.getBoolean("filled" ,false)

       //if ( !filled ) {

            doAsync {

                val images = arrayListOf<String> (
                "https://live.staticflickr.com//65535//50058649837_3b1745c0cf_o.jpg",
                "https://live.staticflickr.com//65535//50057841813_48397a8e06_o.jpg",
                "https://live.staticflickr.com//65535//50058612772_322612ac4a_o.jpg")

                val gson = Gson()
                val imagesString = gson.toJson(images, Images::class.java)


            var country1 =
                Country ("ca" ,
                    "Canada",
                    "https://www.countryflags.io/ca/flat/64.png",
                    "https://upload.wikimedia.org/wikipedia/commons/2/2c/%22O_Canada%22%2C_" +
                            "performed_by_the_United_States_Third_Marine_Aircraft_Wing_Band.oga",
                    "Ottawa",
                    "9,984,670 km2",
                    "37,971,020",
                    "Canada is a country in the northern part of North America. Its ten provinces and three " +
                            "territories extend from the Atlantic to the Pacific and northward into the Arctic Ocean," +
                            " covering 9.98 million square kilometres (3.85 million square miles), making it the world's " +
                            "second-largest country by total area." ,
                    "The history of Canada covers the period from the arrival of the " +
                            "Paleo-Indians thousands of years ago to the present day. Prior to European colonization, " +
                            "the lands encompassing present-day Canada were inhabited for millennia by Indigenous peoples, " +
                            "with distinct trade networks, spiritual beliefs, and styles of social organization. Some of these" +
                            " older civilizations had long faded by the time of the first European arrivals and have been " +
                            "discovered through archeological investigations." +
                            "Starting in the late 15th century, French and British expeditions explored," +
                            " colonized, and fought over various places within North America in what constitutes " +
                            "present-day Canada. The colony of New France was claimed in 1534 with permanent settlements " +
                            "beginning in 1608. France ceded nearly all its North American possessions to the United Kingdom " +
                            "in 1763 after the French defeat in the Seven Years' War. The now British Province of Quebec was" +
                            " divided into Upper and Lower Canada in 1791 and reunified in 1841. In 1867, the Province of " +
                            "Canada was joined with two other British colonies of New Brunswick and Nova Scotia through" +
                            " Confederation, forming a self-governing entity named Canada. The new country expanded by" +
                            " incorporating other parts of British North America, finishing with Newfoundland and Labrador in 1949." +
                            "\n" +
                            "Although responsible government had existed in Canada since 1848, Britain continued to set " +
                            "its foreign and defence policies until the end of the First World War. The passing of the Statute of " +
                            "Westminster in 1931 recognized that Canada had become co-equal with the United Kingdom. After the" +
                            " Constitution was patriated in 1982, the final vestiges of legal dependence on the British parliament" +
                            " were removed. Canada currently consists of ten provinces and three territories and is a parliamentary " +
                            "democracy and a constitutional monarchy with Queen Elizabeth II as its head of state.\n" +
                            "\n" +
                            "Over centuries, elements of Indigenous, French, British and more" +
                            " recent immigrant customs have combined to form a Canadian culture that has also been " +
                            "strongly influenced by its linguistic, geographic and economic neighbour, the United States. " +
                            "Since the conclusion of the Second World War, Canadians have supported multilateralism abroad and socioeconomic " +
                            "development." ,
                         imagesString  ,
                    "",
                    ""
                    )


                dbDao.addCountry(country1)

                val countries = dbDao.getCountries()

                Log.e("Countries Main", countries.toString())


            }

            editor.putBoolean("filled", true).apply()

//        }


        discover_btn.setOnClickListener {
            val intent = Intent(this,CountriesActivity::class.java)
            startActivity(intent)
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
