package com.example.flixster

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView){
    val poster: ImageView

    init{
        poster = itemView.findViewById(R.id.bigPoster)
    }
}