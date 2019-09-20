package com.lambdaschool.sprint4challenge_mymovies.apiaccess

import org.json.JSONException
import org.json.JSONObject

class MovieOverview(json: JSONObject) {
    var vote_average: Double = 0.toDouble()
        private set
    var backdrop_path: String? = null
        private set
    var isAdult: Boolean = false
        private set
    var id: Int = 0
        private set
    var title: String? = null
        private set
    var overview: String? = null
        private set
    var original_language: String? = null
        private set
    var release_date: String? = null
        private set
    var original_title: String? = null
        private set
    var vote_count: Int = 0
        private set
    var poster_path: String? = null
        private set
    var isVideo: Boolean = false
        private set
    var popularity: Double = 0.toDouble()
        private set

    init {
        try {
            this.vote_average = json.getDouble("vote_average")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.backdrop_path = json.getString("backdrop_path")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.isAdult = json.getBoolean("adult")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.id = json.getInt("id")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.title = json.getString("title")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.overview = json.getString("overview")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.original_language = json.getString("original_language")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.release_date = json.getString("release_date")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.original_title = json.getString("original_title")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.vote_count = json.getInt("vote_count")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.poster_path = json.getString("poster_path")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.isVideo = json.getBoolean("video")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.popularity = json.getDouble("popularity")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }
}
