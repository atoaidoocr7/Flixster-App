package com.example.flixster
import org.json.JSONArray

data class PopularMovie(private val posterPath:String,
                        val backdrop: String){

    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    val backDropUrl = "https://image.tmdb.org/t/p/w342/$backdrop"

    companion object{
        fun fromJsonArray(movieJsonArray: JSONArray): List<PopularMovie>{
            val movies = mutableListOf<PopularMovie>()
            for(i in 0 until movieJsonArray.length()){
                val curr = movieJsonArray.getJSONObject(i)
                movies.add(PopularMovie(
                    curr.getString("poster_path"),
                    curr.getString("backdrop_path")
                ))
            }
            return movies
        }
    }

}