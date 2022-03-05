package com.example.flixster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RatingBar
import android.widget.TextView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import okhttp3.Headers

private const val  TAG = "Ato"
private const val TAG1 = "Ato1"
private const val API_KEY = "AIzaSyAagQuOfCiZm6u-0Lg6OwZydN3z_-bRV4"
private const val url = "https://api.themoviedb.org/3/movie/%d/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed"
class DetailActivity : YouTubeBaseActivity() {

    private lateinit var  tvTitle : TextView
    private lateinit var  tvOverview : TextView
    private lateinit var  ratingBar : RatingBar
    private lateinit var ytPlayerView: YouTubePlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        tvTitle = findViewById(R.id.tvTitle)
        tvOverview = findViewById(R.id.tvOverview)
        ratingBar = findViewById(R.id.rbVoteAverage)
        ytPlayerView = findViewById(R.id.player)

        val movie = intent.getParcelableExtra<RegularMovie>(MOVIE_EXTRA) as RegularMovie
        Log.i(TAG, "Movie is: $movie")
        tvTitle.text = movie.title
        tvOverview.text = movie.overView
        ratingBar.rating = movie.voteAvg.toFloat()

        val client = AsyncHttpClient()
        client.get(url.format(movie.movieId), object : JsonHttpResponseHandler(){
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.i(TAG1, "ON FAILUREEEE")

            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                Log.i(TAG1, "ON SUCCESSSSS")
                val results = json.jsonObject.getJSONArray("results")
                if(results.length()==0){
                    Log.w(TAG1, "No movie trailers found")
                    return
                }

                val movieTrailerJson = results.getJSONObject(0)
                val youTubeKey = movieTrailerJson.getString("key")
                //Play video with this trailer
                intitializeYoutube(youTubeKey)
            }

        })

    }

    private fun intitializeYoutube(youtubeKey: String) {
        ytPlayerView.initialize(API_KEY, object: YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider?,
                player: YouTubePlayer?,
                p2: Boolean
            ) {
                Log.i(TAG1, "Video player error");
                player?.cueVideo(youtubeKey);
//                player?.cueVideo("5xVh-7ywKpE");
            }

            val client = AsyncHttpClient()


            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider?,
                player: YouTubeInitializationResult?
            ) {
                Log.i(TAG1, "Failure Story")
            }
        })
    }
}