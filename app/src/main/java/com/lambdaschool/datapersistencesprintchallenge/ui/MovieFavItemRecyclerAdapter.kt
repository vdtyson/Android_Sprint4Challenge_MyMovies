package com.lambdaschool.datapersistencesprintchallenge.ui

import com.lambdaschool.datapersistencesprintchallenge.model.FavoriteMovie
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.lambdaschool.datapersistencesprintchallenge.R
import kotlinx.android.synthetic.main.movie_item_cv.view.*

class MovieFavItemRecyclerAdapter(var movies: List<FavoriteMovie>, val context: Context): RecyclerView.Adapter<MovieFavItemRecyclerAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val titleTextView = view.movieCV_titleTV as TextView
        val overviewTextView = view.movieCV_descriptionTV as TextView
        val deleteBttn = view.movieCV_deleteButton as MaterialButton
        val wasWatchedTV = view.movieCV_wasWatchedTV as TextView
        val wasWatchedBttn = view.movieCV_wasWatchedBttn as ImageButton
        fun wasWatchedBttnOnClickLister(position: Int) {
            if(movies[position].wasWatched == true) {
                movies[position].wasWatched == false
                wasWatchedBttn.setImageResource(R.drawable.ic_visibility_off_black_24dp)
                wasWatchedTV.text = "Not Watched"
            } else {
                movies[position].wasWatched == true
                wasWatchedBttn.setImageResource(R.drawable.ic_visibility_black_24dp)
                wasWatchedTV.text = "Watched!"
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.activity_favorites, parent, false)
        val holder = ViewHolder(viewGroup)
        return holder
    }

    override fun getItemCount(): Int {
      return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.titleTextView.text = movies[position].title
        holder.overviewTextView.text = movies[position].description
    }




}