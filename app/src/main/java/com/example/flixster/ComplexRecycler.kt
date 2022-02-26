package com.example.flixster

import android.content.Context
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ComplexRecycler(private val context: Context, private val items: ArrayList<Any>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val POPULAR = 0;
    private val NONPOPULAR = 1;
    override fun getItemViewType(position: Int): Int {
       if(items.get(position) is RegularMovie){
           return NONPOPULAR
       }else if(items.get(position) is PopularMovie){
           return POPULAR
       }
        return -1;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.movie_item, parent, false)
        var viewholder:RecyclerView.ViewHolder = ViewHolder1(view)
        when(viewType){
            POPULAR->{
                val popular: View
                popular = inflater.inflate(R.layout.layout_view1, parent, false)
                viewholder = ViewHolder1(popular)
            }
            NONPOPULAR->{
                val nonpopular: View
                nonpopular = inflater.inflate(R.layout.movie_item, parent, false)
                viewholder = ViewHolder2(nonpopular)
            }

        }
        return viewholder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            POPULAR -> {

            }
            NONPOPULAR -> {

            }

        }
    }

    private fun configureViewHolder1(holder: ViewHolder1, position: Int) {
        val curr = items.get(position) as RegularMovie
        if (curr != null) {
            holder.title.text = curr.title
            holder.overview.text = curr.overView
            val orientation = context.resources.configuration.orientation
            if(orientation== Configuration.ORIENTATION_LANDSCAPE){
                Glide.with(context).load(curr.backDropUrl).into(holder.poster)
            }else{
                Glide.with(context).load(curr.posterImageUrl).into(holder.poster)
            }
        }
    }

    private fun configureViewHolder2(holder: ViewHolder1, position: Int) {
        val curr = items.get(position) as PopularMovie
        if (curr != null) {
            val orientation = context.resources.configuration.orientation
            if(orientation== Configuration.ORIENTATION_LANDSCAPE){
                Glide.with(context).load(curr.backDropUrl).into(holder.poster)
            }else{
                Glide.with(context).load(curr.posterImageUrl).into(holder.poster)
            }
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

}