package com.example.flixster



import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

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
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //        private val title = itemView.findViewById<TextView>(R.id.mvTitle)
//        private val overview = itemView.findViewById<TextView>(R.id.mvOverview)
//        private val poster = itemView.findViewById<TextView>(R.id.mvPoster)
        val title : TextView
        val overview: TextView
        val poster: ImageView
        //        fun bind(movie: Movie){
//            title.text = movie.title
//            overview.text = movie.overView
//        }
        init{
            title = itemView.findViewById(R.id.mvTitle)
            overview = itemView.findViewById(R.id.mvOverview)
            poster = itemView.findViewById(R.id.mvPoster)
        }
    }
}