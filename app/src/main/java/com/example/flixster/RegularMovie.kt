package com.example.flixster

import org.json.JSONArray

data class RegularMovie(val movieId: Int, private val posterPath:String, val title: String,
                        val overView: String, val backdrop: String){

    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    val backDropUrl = "https://image.tmdb.org/t/p/w342/$backdrop"

    companion object{

        fun fromJsonArray(movieJsonArray: JSONArray): List<RegularMovie>{
            val movies = mutableListOf<RegularMovie>()
            for(i in 0 until movieJsonArray.length()){
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(RegularMovie(
                    movieJson.getInt("id"),
                    movieJson.getString("poster_path"),
                    movieJson.getString("title"),
                    movieJson.getString("overview"),
                    movieJson.getString("backdrop_path")
                ))
            }
            return movies
        }

        fun getLandscape(jsonArray: JSONArray): List<String>{
            val arr = mutableListOf<String>()
            for(i in 0 until jsonArray.length()){
                val curr = jsonArray.getJSONObject(i)
                arr.add(curr.getString("backdrop_path"))
            }
            return arr;
        }
    }
}
