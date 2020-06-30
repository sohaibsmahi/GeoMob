package com.example.geomob

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.geomob.R
import com.example.geomob.data.Country

class ListAdapter(private val context: Context,val clickListner: OnClickListner, private val list: MutableList<Country>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.country, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {

        holder.initialize(list[p1],context,clickListner)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val countryName: TextView = v.findViewById(R.id.country_name)
        val countryImage : ImageView = v.findViewById(R.id.country_image)

        fun initialize(country: Country, context: Context, action:OnClickListner){

            countryName.text = country.name

            Glide.with(context).load(country.drapeau).apply(RequestOptions.circleCropTransform()).into(countryImage);

            itemView.setOnClickListener{
                action.onItemClick(country,adapterPosition)
            }

        }
    }

    interface OnClickListner{
        fun onItemClick(item: Country, p1:Int)
    }

}
