package com.lambdaschool.datapersistencesprintchallenge.ui

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lambdaschool.datapersistencesprintchallenge.R
import com.lambdaschool.datapersistencesprintchallenge.db.AppDatabase
import com.lambdaschool.datapersistencesprintchallenge.model.FavoriteMovie
import kotlinx.android.synthetic.main.activity_main.*

class FavoritesActivity : AppCompatActivity() {


    var movieList: List<FavoriteMovie>? = listOf()
    val favRvAdapter = MovieFavItemRecyclerAdapter(movieList!!, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val db = AppDatabase.getAppDataBase(this)
        movieList =

        initFavRecyclerView()
    }

    fun initFavRecyclerView() {
        mainActivity_rv.apply {
            layoutManager = LinearLayoutManager(this@FavoritesActivity)
            adapter = favRvAdapter
        }
    }

}
