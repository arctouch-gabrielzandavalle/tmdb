package com.arctouch.gabrielzandavalle.tmdb

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arctouch.gabrielzandavalle.tmdb.adapter.MovieAdapter
import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import com.arctouch.gabrielzandavalle.tmdb.service.MovieListPresenter
import kotlinx.android.synthetic.main.fragment_home.moviesRecyclerView

/**
 * Created by gabrielzandavalle on 1/19/17.
 */
class HomeFragment : Fragment(), MovieListView {

  lateinit var movieListPresenter:  MovieListPresenter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    super.onCreateView(inflater, container, savedInstanceState)

    val view = inflater.inflate(R.layout.fragment_home, container, false)

    movieListPresenter = MovieListPresenter(this.activity, this)
    movieListPresenter.showMovieList()

    return view
  }

  override fun loadMovies(movies: List<Movie>) {
    moviesRecyclerView.adapter = MovieAdapter(movies)
    moviesRecyclerView.layoutManager = LinearLayoutManager(this@HomeFragment.activity)
  }
}