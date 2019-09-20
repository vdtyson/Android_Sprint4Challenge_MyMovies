package com.lambdaschool.datapersistencesprintchallenge

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview

@Entity
class FavoriteMovie (

    @PrimaryKey(autoGenerate = true)
    val favId: Int,
    val title: Int,
    val overview: String,
    val userRating: Int,
    val description: String
) {

}