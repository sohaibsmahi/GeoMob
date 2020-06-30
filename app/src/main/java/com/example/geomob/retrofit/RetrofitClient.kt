package com.example.geomob.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.twitter.com/labs/1/tweets/search?query="

object RetrofitClient {

    private var ourinstance : Retrofit?=null

    val instance : Retrofit
        get() {

            if (ourinstance == null ) {
                ourinstance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            }
            return ourinstance!!

        }





}