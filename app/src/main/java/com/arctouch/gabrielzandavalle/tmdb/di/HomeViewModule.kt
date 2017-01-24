package com.arctouch.gabrielzandavalle.tmdb.di

import com.arctouch.gabrielzandavalle.tmdb.MovieListView
import com.arctouch.gabrielzandavalle.tmdb.service.MovieListPresenter
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import dagger.Module
import dagger.Provides

/**
 * Created by gabrielzandavalle on 1/24/17.
 */
@Module
class HomeViewModule(val movieListView: MovieListView) {

  @Provides
  fun provideMovieListPresenter(tmdbApi: TmdbApiInterface) : MovieListPresenter{
    return MovieListPresenter(movieListView, tmdbApi)
  }
}