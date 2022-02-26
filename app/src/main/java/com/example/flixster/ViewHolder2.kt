package com.example.flixster

import android.view.View
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val bigPoster : ImageView
    init{
        bigPoster = itemView.findViewById<ImageView>(R.id.bigPoster)
    }
}