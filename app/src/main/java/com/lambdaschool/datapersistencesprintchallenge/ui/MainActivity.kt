package com.lambdaschool.datapersistencesprintchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.lambdaschool.datapersistencesprintchallenge.R
import com.lambdaschool.datapersistencesprintchallenge.apiaccess.MovieRequestInterface
import com.lambdaschool.datapersistencesprintchallenge.model.FavoriteMovie
import com.lambdaschool.sprint4challenge_mymovies.apiaccess.MovieConstants
import com.lambdaschool.sprint4challenge_mymovies.apiaccess.NetworkAdapter
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), Callback<List<MovieOverview>> {

    var movies = listOf<MovieOverview>()
    val rAdapter = MovieSearchItemRecyclerAdapter(movies, this)

    override fun onFailure(call: Call<List<MovieOverview>>, t: Throwable) {
        Log.i("Failure", "There has been and error")
    }

    override fun onResponse(call: Call<List<MovieOverview>>, response: Response<List<MovieOverview>>) {
        if(response.isSuccessful) {
            movies = response.body()!!
            rAdapter.update(movies)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

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
