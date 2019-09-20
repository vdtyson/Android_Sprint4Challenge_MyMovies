package com.lambdaschool.datapersistencesprintchallenge.ui

import com.lambdaschool.datapersistencesprintchallenge.model.FavoriteMovie
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.movie_item_cv.view.*

class MovieFavItemRecyclerAdapter(var movies: List<FavoriteMovie>, val context: Context): RecyclerView.Adapter<MovieFavItemRecyclerAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val titleTextView = view.movieCV_titleTV as TextView
        val overviewTextView = view.movieCV_descriptionTV as TextView
        val deleteBttn = view.movieCV_deleteButton as MaterialButton
        val wasWatchedTV = view.movieCV_wasWatchedTV as TextView
        val wasWatchedBttn = view.movieCV_wasWatchedBttn as ImageButton
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




}