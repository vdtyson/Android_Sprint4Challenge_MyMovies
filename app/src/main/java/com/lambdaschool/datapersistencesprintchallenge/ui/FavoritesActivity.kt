package com.lambdaschool.datapersistencesprintchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lambdaschool.datapersistencesprintchallenge.R
import com.lambdaschool.datapersistencesprintchallenge.db.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*

class FavoritesActivity : AppCompatActivity() {

    val db = AppDatabase.getAppDataBase(this)
    val movieList = db!!.favMovieDao().getAllFavoriteMovies()
    val favRvAdapter = MovieFavItemRecyclerAdapter(movieList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        initFavRecyclerView()
    }

    fun initFavRecyclerView() {
        mainActivity_rv.apply {
            layoutManager = LinearLayoutManager(this@FavoritesActivity)
            adapter = favRvAdapter
        }
    }

}
