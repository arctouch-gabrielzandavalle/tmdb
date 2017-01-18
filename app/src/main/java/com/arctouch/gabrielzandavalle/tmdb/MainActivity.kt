package com.arctouch.gabrielzandavalle.tmdb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arctouch.gabrielzandavalle.tmdb.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.moviesList

class MainActivity: AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    moviesList.adapter = MovieAdapter()
    moviesList.layoutManager = LinearLayoutManager(this)
  }
}
