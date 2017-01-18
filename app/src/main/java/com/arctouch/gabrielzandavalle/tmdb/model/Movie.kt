package com.arctouch.gabrielzandavalle.tmdb.model

/**
 * Created by gabrielzandavalle on 1/17/17.
 */
 data class Movie (
    @com.google.gson.annotations.SerializedName("poster_path")
    val posterPath: String = "",
    val title: String = "",
    val overview: String = ""

)