package com.example.flixster

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView){
    val title : TextView
    val overview: TextView
    val poster: ImageView

    init{
        title = itemView.findViewById(R.id.mvTitle)
        overview = itemView.findViewById(R.id.mvOverview)
        poster = itemView.findViewById(R.id.mvPoster)
    }
}