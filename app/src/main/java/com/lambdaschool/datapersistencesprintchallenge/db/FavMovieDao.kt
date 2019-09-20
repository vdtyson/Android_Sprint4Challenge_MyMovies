package com.lambdaschool.datapersistencesprintchallenge.db

import androidx.room.*
import com.lambdaschool.datapersistencesprintchallenge.model.FavoriteMovie

@Dao
interface FavMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteMovie(favoriteMovie: FavoriteMovie)

    @Update
    fun updateFavoriteMovie(favoriteMovie: FavoriteMovie)

    @Delete
    fun deleteFavoriteMovie(favoriteMovie: FavoriteMovie)

    @Query("SELECT * FROM FavoriteMovie WHERE title == title")
    fun getFavoriteMovieByTitle(name: String): List<FavoriteMovie>
}