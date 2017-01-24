package com.arctouch.gabrielzandavalle.tmdb.di

import android.content.Context
import com.arctouch.gabrielzandavalle.tmdb.MovieListView
import com.arctouch.gabrielzandavalle.tmdb.service.MovieListPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by gabrielzandavalle on 1/24/17.
 */
@Module
class HomeViewModule(val context: Context, val movieListView: MovieListView) {

  @Provides
  fun provideMovieListPresenter() : MovieListPresenter{
    return MovieListPresenter(context, movieListView)
  }
}