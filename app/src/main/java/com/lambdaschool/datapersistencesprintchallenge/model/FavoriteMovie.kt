package com.lambdaschool.datapersistencesprintchallenge.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview

@Entity
class FavoriteMovie (

    @PrimaryKey(autoGenerate = true)
    val favId: Int? = null,
    val title: String,
    val wasWatched: Boolean = false,
    val description: String
) {

}