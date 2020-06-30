package com.example.geomob

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.data.Data


class TweetsAdapter( val tweets : List<Data> , private val context: Context) : RecyclerView.Adapter<TweetsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.tweet, p0, false) , context)
    }

    override fun getItemCount(): Int {

        return tweets.size
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {

        holder.tweet_content.text = tweets[p1].text


    }

    class ViewHolder(v: View , val context: Context) : RecyclerView.ViewHolder(v) {

        val tweet_content : TextView = v.findViewById(R.id.content)


        }
    }
