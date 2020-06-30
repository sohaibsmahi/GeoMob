package com.example.geomob.retrofit

import com.example.geomob.data.Tweets
import io.reactivex.Observable
import retrofit2.http.*


interface IAPI {

    @GET("{country}/")
    fun getTweets( @Header("Authorization") Authorization: String,@Path("country") country: String): Observable<Tweets>


}