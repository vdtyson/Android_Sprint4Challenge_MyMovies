package com.lambdaschool.datapersistencesprintchallenge.apiaccess

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class MovieAPI {

    @GET("/search/movie?api_key={api_key}&query={query}")
    fun searchMovie(@Path("api_key") api_key: String) {}
}