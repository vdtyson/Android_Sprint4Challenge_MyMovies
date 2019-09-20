package com.lambdaschool.sprint4challenge_mymovies.apiaccess

import android.graphics.Bitmap

object MovieConstants {
    private val BASE_URL = "https://api.themoviedb.org/3"
    private val API_KEY_PARAM = "?api_key=b98f8f717026d85eb364fe4ac55cd214"
    private val QUERY_PARAMS = "&language=en-US&query=%s&page=%d&include_adult=false"
    private val POPULAR_MOVIES = "$BASE_URL/movie/popular$API_KEY_PARAM"
    private val SEARCH_MOVIES = "$BASE_URL/search/movie$API_KEY_PARAM$QUERY_PARAMS"
    private val GET_MOVIE_WITH_ID = "$BASE_URL/movie/%s$API_KEY_PARAM"

    private val HARD_CODED = "https://api.themoviedb.org/3/search/movie?api_key=b98f8f717026d85eb364fe4ac55cd214&language=en-US&query=batman the&page=all&include_adult=false"

    private val IMAGE_URL = "https://image.tmdb.org/t/p/"
    private val POSTER_SIZES = arrayOf("w92", "w154", "w185", "w342", "w500", "w780", "original")

    private val JPG = ".jpg"
    private val JSON = ".json"

    fun getPoster(imagePath: String): Bitmap? {
        return NetworkAdapter.getBitmapFromURL(IMAGE_URL + POSTER_SIZES[6] + imagePath)
    }

    fun getImage(id: String): Bitmap? {
        return NetworkAdapter.getBitmapFromURL(IMAGE_URL + id + JPG)
    }
}
