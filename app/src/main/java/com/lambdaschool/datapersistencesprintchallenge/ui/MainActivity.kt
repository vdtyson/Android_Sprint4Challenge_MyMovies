package com.lambdaschool.datapersistencesprintchallenge.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.lambdaschool.datapersistencesprintchallenge.R
import com.lambdaschool.datapersistencesprintchallenge.apiaccess.MovieRequestInterface
import com.lambdaschool.datapersistencesprintchallenge.model.FavoriteMovie
import com.lambdaschool.datapersistencesprintchallenge.model.MovieSearchResult
import com.lambdaschool.sprint4challenge_mymovies.apiaccess.MovieConstants
import com.lambdaschool.sprint4challenge_mymovies.apiaccess.NetworkAdapter
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), Callback<MovieSearchResult> {

    var movies = listOf<MovieOverview>()
    var rAdapter = MovieSearchItemRecyclerAdapter(movies, this)

    override fun onFailure(call: Call<MovieSearchResult>, t: Throwable) {
        Log.i("Failure", "There has been and error")
    }

    override fun onResponse(call: Call<MovieSearchResult>, response: Response<MovieSearchResult>) {
        if(response.isSuccessful) {
            val movies = response.body()?.results
            rAdapter.update(movies!!)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        mainActivity_favoriteBttn.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java )
            startActivity(intent)
        }
        mainActivity_submitBttn.setOnClickListener {
            var queryText: String = mainActivity_searchView.text.toString()
            if(queryText.isNotBlank()) {
                getMovies(queryText)
            }
        }

    }


    fun initRecyclerView() {
        mainActivity_rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rAdapter
        }
    }

    fun getMovies(queryText: String) {
        val retriever = MovieRequestInterface.create()
        retriever.searchMovie(MovieConstants.API_KEY_PARAM, queryText).enqueue(this)
    }
}
