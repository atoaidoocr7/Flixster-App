package com.example.flixster
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONException

private const val MOVIE_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed"
private const val TAG = "Ato"

class MainActivity : AppCompatActivity() {
    var movies = mutableListOf<RegularMovie>()
    var posters= mutableListOf<PopularMovie>()
    var objs = ArrayList<Any>()
    lateinit var mvAdapter: ComplexRecycler
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)

        mvAdapter = ComplexRecycler(this,objs)
        recyclerView.adapter = mvAdapter
//
        recyclerView.layoutManager = LinearLayoutManager(this)


        val client = AsyncHttpClient()

        client.get(MOVIE_URL, object: JsonHttpResponseHandler(){
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "ERROR FAILURE $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                try{
                    Log.i(TAG,"SUCCESS: JSON DATA: $json")
                    val movieJsonArray = json.jsonObject.getJSONArray("results")
//                    movies.addAll(RegularMovie.fromJsonArray(movieJsonArray))
                    objs.addAll(RegularMovie.fromJsonArray(movieJsonArray))
                    Log.i(TAG,"MOVIE LIST WORKS: $movies")
                    posters.addAll(PopularMovie.fromJsonArray(movieJsonArray))
                    Log.i(TAG, "BACK-DROP PATH: $posters")
                    mvAdapter.notifyDataSetChanged()
                }catch(e: JSONException){
                    Log.e(TAG, "JSON ERROR ")
                }


            }

        })
    }
}