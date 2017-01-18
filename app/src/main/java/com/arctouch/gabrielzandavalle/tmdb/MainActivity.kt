package com.arctouch.gabrielzandavalle.tmdb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arctouch.gabrielzandavalle.tmdb.adapter.MovieAdapter
import com.arctouch.gabrielzandavalle.tmdb.model.MovieListResponse
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import kotlinx.android.synthetic.main.activity_main.moviesList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Callback
import retrofit2.Response

class MainActivity: AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val baseUrl = "https://api.themoviedb.org/3/";
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    val tmdbApi = retrofit.create(TmdbApiInterface::class.java)

    val list: Call<MovieListResponse> = tmdbApi.getList("1",
        "1f54bd990f1cdfb230adb312546d765d")

    list.enqueue(object: Callback<MovieListResponse> {

      override fun onResponse(call: Call<MovieListResponse>?, response: Response<MovieListResponse>?) {
        moviesList.adapter = MovieAdapter(response?.body()?.items!!)
        moviesList.layoutManager = LinearLayoutManager(this@MainActivity)
      }

      override fun onFailure(call: Call<MovieListResponse>?, t: Throwable?) {
        System.out.print(t?.message)
      }
    });
  }
}
