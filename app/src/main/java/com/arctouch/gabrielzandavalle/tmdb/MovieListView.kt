package com.arctouch.gabrielzandavalle.tmdb

import com.arctouch.gabrielzandavalle.tmdb.model.Movie

/**
 * Created by gabrielzandavalle on 1/24/17.
 */

interface MovieListView {
  fun loadMovies(movies: List<Movie>)
}