package com.arctouch.gabrielzandavalle.tmdb.di

import com.arctouch.gabrielzandavalle.tmdb.detail.DetailFragment
import com.arctouch.gabrielzandavalle.tmdb.home.MovieListPresenter
import dagger.Subcomponent

/**
 * Created by gabrielzandavalle on 1/19/17.
 */

@ActivityScope
@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent{

  //criar classes separadas.
  fun inject(detailFragment: DetailFragment)
  fun inject(movieListPresenter: MovieListPresenter)
}
