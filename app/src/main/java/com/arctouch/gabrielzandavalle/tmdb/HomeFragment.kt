package com.arctouch.gabrielzandavalle.tmdb

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arctouch.gabrielzandavalle.tmdb.adapter.MovieAdapter
import com.arctouch.gabrielzandavalle.tmdb.di.HomeViewModule
import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import com.arctouch.gabrielzandavalle.tmdb.service.MovieListPresenter
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import kotlinx.android.synthetic.main.fragment_home.moviesRecyclerView
import javax.inject.Inject

/**
 * Created by gabrielzandavalle on 1/19/17.
 */
class HomeFragment : Fragment(), MovieListView {

  @Inject
  lateinit var tmdbApi: TmdbApiInterface

  @Inject
  lateinit var movieListPresenter:  MovieListPresenter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    super.onCreateView(inflater, container, savedInstanceState)

    initConfiguration()

    val view = inflater.inflate(R.layout.fragment_home, container, false)

    movieListPresenter.showMovieList()

    return view
  }

  private fun initConfiguration() {
    TmdbApplication.get(this.activity)
        .applicationComponent
        .plus(HomeViewModule(this))
        .inject(this)
  }

  override fun loadMovies(movies: List<Movie>) {
    moviesRecyclerView.adapter = MovieAdapter(movies)
    moviesRecyclerView.layoutManager = LinearLayoutManager(this@HomeFragment.activity)
  }
}