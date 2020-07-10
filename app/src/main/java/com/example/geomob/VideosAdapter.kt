package com.example.geomob


import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.data.Images


class VideosAdapter(val videos : Images, private val context: Context) : RecyclerView.Adapter<VideosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.video, p0, false) , context)
    }

    override fun getItemCount(): Int {

        return videos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {

        if (! videos[p1].isEmpty() ) {

            holder.videoImage.setVideoURI(Uri.parse(videos[p1]))
            holder.videoImage.setMediaController(MediaController(context))
            holder.videoImage.requestFocus()



            Log.e("image" , videos[p1].isEmpty().toString())
        }



    }

    class ViewHolder(v: View , val context: Context) : RecyclerView.ViewHolder(v) {

        val videoImage : VideoView = v.findViewById(R.id.video)


    }
}
