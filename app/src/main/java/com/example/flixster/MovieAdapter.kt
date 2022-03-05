package com.example.flixster

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
const val MOVIE_EXTRA = "MOVIE_EXTRA"
private  const val TAG = "MovieAdapter"
class MovieAdapter(private val context: Context, private val movies: List<RegularMovie>, private val posters: List<String>)
    :RecyclerView.Adapter<MovieAdapter.ViewHolder>() {



    //expensive operation
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "oCreateViewHolder")
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.movie_item, parent, false);
        return ViewHolder(view)
    }

    //cheap operation
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder")
        val movie = movies.get(position)
        holder.title.text = movie.title
        holder.overview.text = movie.overView
        val orientation = context.resources.configuration.orientation
        if(orientation== Configuration.ORIENTATION_LANDSCAPE){
            Glide.with(context).load(movie.backDropUrl).into(holder.poster)
        }else{
            Glide.with(context).load(movie.posterImageUrl).into(holder.poster)
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val title : TextView
        val overview: TextView
        val poster: ImageView

        init{
            title = itemView.findViewById(R.id.mvTitle)
            overview = itemView.findViewById(R.id.mvOverview)
            poster = itemView.findViewById(R.id.mvPoster)
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            //Get notified of movie that was tapped on
            //adater position is built in and gives us position of current movie clicked on
            val movie = movies[adapterPosition]
//            Toast.makeText(context, movie.title,Toast.LENGTH_SHORT).show()
            //Use intent system to navigate to new activity

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, movie)
            context.startActivity(intent)
        }
    }
}