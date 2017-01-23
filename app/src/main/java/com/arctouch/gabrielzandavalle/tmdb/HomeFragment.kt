package com.arctouch.gabrielzandavalle.tmdb

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arctouch.gabrielzandavalle.tmdb.adapter.MovieAdapter
import com.arctouch.gabrielzandavalle.tmdb.di.MainActivityModule
import com.arctouch.gabrielzandavalle.tmdb.model.MovieListResponse
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import kotlinx.android.synthetic.main.fragment_home.moviesRecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by gabrielzandavalle on 1/19/17.
 */
class HomeFragment : Fragment() {

  val TAG = MainActivity::class.java.name

  @Inject
  lateinit var tmdbApi: TmdbApiInterface

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    super.onCreateView(inflater, container, savedInstanceState)

    val view = inflater.inflate(R.layout.fragment_home, container, false)

    initConfiguration()

    val list: Call<MovieListResponse> = tmdbApi.getList("1", "1f54bd990f1cdfb230adb312546d765d")

    list.enqueue(object: Callback<MovieListResponse> {

      override fun onResponse(call: Call<MovieListResponse>?, response: Response<MovieListResponse>?) {
        val movies = response?.body()?.items!!
        moviesRecyclerView.adapter = MovieAdapter(movies)
        moviesRecyclerView.layoutManager = LinearLayoutManager(this@HomeFragment.activity)
      }

      override fun onFailure(call: Call<MovieListResponse>?, t: Throwable?) {
        Log.d(TAG, t?.message)
      }
    })

    return view
  }

  private fun initConfiguration() {
    TmdbApplication.get(this.activity)
        .applicationComponent
        .plus(MainActivityModule())
        .inject(this)
  }
}