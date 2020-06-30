package com.example.geomob


import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.models.SlideModel
import com.example.geomob.data.Data
import com.example.geomob.data.Images
import com.example.geomob.retrofit.IAPI
import com.example.geomob.retrofit.RetrofitClient
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_countries.*
import kotlinx.android.synthetic.main.activity_country_detail.*


class CountryDetailActivity : AppCompatActivity() {

    lateinit var mediaPlayer: MediaPlayer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        rv_tweets.layoutManager = LinearLayoutManager(this)



        //-----------------------------------------------------------------------------------------------------------------

        name.text =  intent.getStringExtra("name")
        capital.text = intent.getStringExtra("capital")
        population.text = intent.getStringExtra("population") + " millions "
        surface.text = intent.getStringExtra("surface") + " km²"
        description.text = intent.getStringExtra("description")
        expand_text_view.setText(intent.getStringExtra("historique"))

        Glide.with(this).load(intent.getStringExtra("drapeau")).into(flag);


         play.setOnClickListener{

             val hymneUrl = intent.getStringExtra("hymne")  // your URL here

           mediaPlayer = MediaPlayer().apply {
               setAudioStreamType(AudioManager.STREAM_MUSIC)
               setDataSource(hymneUrl)
               prepare() // might take long! (for buffering, etc)
               start()
           }

             }


        stop.setOnClickListener{

            if (  mediaPlayer.isPlaying ) mediaPlayer.apply { stop() }

        }

        val gson = Gson()

        val imagesString = intent.getStringExtra("images")

        val images : ArrayList<String> =  gson.fromJson( imagesString , Images::class.java)

        val imageList = ArrayList<SlideModel>()
          images.forEach { imageUrl ->
               imageList.add(SlideModel(imageUrl))
                slider.setImageList(imageList)
           }

        wikipedia_btn.setOnClickListener {

            val intentWiki = Intent(this,WikipediaActivity::class.java)
            intentWiki.putExtra("search", intent.getStringExtra("name"))
            startActivity(intentWiki)

        }

       fetchTweets("canada", this )

        }


    fun fetchTweets (country_name:String , context : Context ) {

        val compositeDisposable = CompositeDisposable()
        val retrofit = RetrofitClient.instance
        val jsonAPI = retrofit.create(IAPI::class.java)
        val bearertoken = "Bearer AAAAAAAAAAAAAAAAAAAAAIpGFgEAAAAASCdEQe7UxzAaQ44yZ%2BToTxOyF04%3D4LtxXsyqv7EmPDm48LIKrYnCeIgqRK4FUCWo5YYT46Z6nU2a1m"

        compositeDisposable.add( jsonAPI.getTweets(bearertoken , country_name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ tweets ->

                Log.e("TWeeets", tweets.data.toString())
              displayTweets(tweets.data , context)

            }, { error  ->  Toast.makeText(context , error.message ,
                Toast.LENGTH_LONG).show() } )
        )

    }


    fun displayTweets (tweets: List<Data>, context : Context) {
        Log.e("tweets" , tweets.toString())
        rv_tweets.adapter = TweetsAdapter(tweets , context)

    }




}
