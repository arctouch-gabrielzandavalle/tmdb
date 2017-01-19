package com.arctouch.gabrielzandavalle.tmdb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arctouch.gabrielzandavalle.tmdb.adapter.MovieAdapter
import com.arctouch.gabrielzandavalle.tmdb.di.MainActivityModule
import com.arctouch.gabrielzandavalle.tmdb.model.MovieListResponse
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import kotlinx.android.synthetic.main.activity_main.moviesList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

  @Inject
  lateinit var retrofit: Retrofit

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    initConfiguration();

    val tmdbApi = retrofit.create(TmdbApiInterface::class.java)

    val list: Call<MovieListResponse> = tmdbApi.getList("1",
        "1f54bd990f1cdfb230adb312546d765d")

    list.enqueue(object: Callback<MovieListResponse> {

      override fun onResponse(call: Call<MovieListResponse>?, response: Response<MovieListResponse>?) {
        moviesList.adapter = MovieAdapter(this@MainActivity, response?.body()?.items!!)
        moviesList.layoutManager = LinearLayoutManager(this@MainActivity)
      }

      override fun onFailure(call: Call<MovieListResponse>?, t: Throwable?) {
        System.out.print(t?.message)
      }
    });
  }

  private fun initConfiguration() {
    TmdbApplication.get(this)
        .applicationComponent
        .plus(MainActivityModule())
        .inject(this)
  }
}
