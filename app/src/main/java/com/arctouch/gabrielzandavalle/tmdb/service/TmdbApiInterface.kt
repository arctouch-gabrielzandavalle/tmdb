package com.arctouch.gabrielzandavalle.tmdb.service

import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import com.arctouch.gabrielzandavalle.tmdb.model.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by gabrielzandavalle on 1/18/17.
 */

interface TmdbApiInterface {

  @GET("list/{id}")
  fun getList(@Path("id") id: String, @Query("api_key") apiKey: String ) :
      Call<MovieListResponse>
}