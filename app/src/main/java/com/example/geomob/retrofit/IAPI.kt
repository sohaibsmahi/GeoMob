package com.example.geomob.retrofit

import com.example.geomob.data.Response
import io.reactivex.Observable
import retrofit2.http.*


interface IAPI {

    @GET("search")

    fun getTweets( @Header("Authorization") Authorization: String,@Query("query") country: String): Observable<Response>


}