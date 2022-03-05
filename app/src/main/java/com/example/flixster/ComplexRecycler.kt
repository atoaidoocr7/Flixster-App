//package com.example.flixster
//
//import android.content.Context
//import android.content.res.Configuration
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.bumptech.glide.R
//
//private const val TAG = "Ato"
//class ComplexRecycler(private val context: Context, private val items: ArrayList<Any>)
//    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//
//    override fun getItemCount(): Int {
//        return items.size;
//    }
//    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
//        Log.i(TAG, "onBindViewHolder")
//        val movie = items.get(position) as RegularMovie
//        holder.title.text = movie.title
//        holder.overview.text = movie.overView
//        val orientation = context.resources.configuration.orientation
//        if(orientation== Configuration.ORIENTATION_LANDSCAPE){
//            Glide.with(context).load(movie.backDropUrl).into(holder.poster)
//        }else{
//            Glide.with(context).load(movie.posterImageUrl).into(holder.poster)
//        }
//
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
//        Log.i(TAG, "oCreateViewHolder")
//        val inflater = LayoutInflater.from(context)
//        val view = inflater.inflate(R.layout.movie_item, parent, false);
//        return ViewHolder1(view)
//    }
//
////    override fun getItemViewType(position: Int): Int {
////        return if(items[position] is PopularMovie){
////            0;
////        }else {
////            1
////        }
////    }
//
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
////        lateinit var viewHolder: RecyclerView.ViewHolder
////        val inflater = LayoutInflater.from(context)
////        when(viewType){
////            1->{
////                val v1: View = inflater.inflate(R.layout.movie_item, parent,false)
////                viewHolder = ViewHolder1(v1)
////            }
////            0->{
////                val v2: View = inflater.inflate(R.layout.layout_view1, parent,false)
////                viewHolder = ViewHolder2(v2)
////            }
////            else->{
////                Log.i(TAG, "Invalid in on create view holder")
////            }
////        }
////        return viewHolder
////    }
//
////    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
////        when (viewHolder.itemViewType) {
////            1 -> {
////                val vh1 = viewHolder as ViewHolder1
////                configViewHolder1(vh1, position)
////            }
////            0 -> {
////                val vh2 = viewHolder as ViewHolder2
////                configViewHolder2(vh2, position)
////            }
////            else -> {
////                Log.i(TAG, "Invalid in on bind view holder")
////            }
////        }
////    }
//
////    private fun configViewHolder1(holder: ViewHolder1, position: Int){
////        Log.i(TAG, "onBindViewHolder")
////        val movie =items.get(position) as RegularMovie
////        holder.title.text = movie.title
////        holder.overview.text = movie.overView
////        val orientation = context.resources.configuration.orientation
////        if(orientation== Configuration.ORIENTATION_LANDSCAPE){
////            Glide.with(context).load(movie.backDropUrl).into(holder.poster)
////        }else{
////            Glide.with(context).load(movie.posterImageUrl).into(holder.poster)
////        }
////
////    }
////    private fun configViewHolder2(holder: ViewHolder2, position: Int){
////        Log.i(TAG, "onBindViewHolder")
////        val movie =items.get(position) as PopularMovie
////        val orientation = context.resources.configuration.orientation
////        if(orientation== Configuration.ORIENTATION_LANDSCAPE){
////            Glide.with(context).load(movie.backDropUrl).into(holder.poster)
////        }else{
////            Glide.with(context).load(movie.posterImageUrl).into(holder.poster)
////        }
////    }
//
//
//
//}