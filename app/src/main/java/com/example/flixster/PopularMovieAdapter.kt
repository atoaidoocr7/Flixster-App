package com.example.flixster

import android.content.Context
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PopularMovieAdapter(private val context: Context, private val posters:
    List<PopularMovie>):RecyclerView.Adapter<PopularMovieAdapter.ViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.layout_view1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val poster = posters.get(position)
        val orientation = context.resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            Glide.with(context).load(poster.backDropUrl).into(holder.bigPoster)
        }else{
            Glide.with(context).load(poster.posterImageUrl).into(holder.bigPoster)
        }
    }

    override fun getItemCount(): Int {
        return posters.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val bigPoster : ImageView
        init{
            bigPoster = itemView.findViewById<ImageView>(R.id.bigPoster)
        }
    }

}