package com.arctouch.gabrielzandavalle.tmdb.detail

import com.arctouch.gabrielzandavalle.tmdb.model.Movie

/**
 * Created by gabrielzandavalle on 1/25/17.
 */
interface DetailView {
  fun showMovieDetail(movie: Movie)
}