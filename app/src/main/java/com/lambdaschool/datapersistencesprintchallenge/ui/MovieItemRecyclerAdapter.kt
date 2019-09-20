package com.lambdaschool.datapersistencesprintchallenge.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.datapersistencesprintchallenge.R
import com.lambdaschool.datapersistencesprintchallenge.db.FavMovieDao
import com.lambdaschool.datapersistencesprintchallenge.model.FavoriteMovie
import com.lambdaschool.datapersistencesprintchallenge.model.MovieSearchResult
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview
import kotlinx.android.synthetic.main.movie_search_cv.view.*

class MovieSearchItemRecyclerAdapter(var movies: List<MovieOverview>): RecyclerView.Adapter<MovieSearchItemRecyclerAdapter.ViewHolder>(), FavMovieDao{
    override fun insertFavoriteMovie(favoriteMovie: FavoriteMovie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateFavoriteMovie(favoriteMovie: FavoriteMovie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteFavoriteMovie(favoriteMovie: FavoriteMovie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFavoriteMovieByTitle(name: String): List<FavoriteMovie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieTitleTextView = view.movieSearchCV_TV as TextView
        val favButton = view.movieSearchCV_favBttn as ImageButton
        fun favButtonOnClick(position: Int) {
            val title = movies[position].title
            val description = movies[position].overview
            val favMovie = FavoriteMovie(title = title, description = description)
            insertFavoriteMovie(favMovie)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.movie_search_cv, parent, false)
        val holder= ViewHolder(viewGroup)
        return holder
    }



    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieSearchItemRecyclerAdapter.ViewHolder, position: Int) {
        holder.movieTitleTextView.text = movies[position].title
        holder.favButton.setOnClickListener {
            holder.favButtonOnClick(position)
        }
    }

    fun update(newMovies: List<MovieOverview>) {
        movies = newMovies
        notifyDataSetChanged()
    }
}