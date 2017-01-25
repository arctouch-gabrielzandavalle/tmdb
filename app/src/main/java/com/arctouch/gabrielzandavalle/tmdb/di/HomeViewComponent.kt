package com.arctouch.gabrielzandavalle.tmdb.di

import com.arctouch.gabrielzandavalle.tmdb.home.HomeFragment
import com.arctouch.gabrielzandavalle.tmdb.home.MovieListView
import dagger.Subcomponent

/**
 * Created by gabrielzandavalle on 1/24/17.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(HomeViewModule::class))
interface HomeViewComponent {
  fun inject(homeFragment: HomeFragment)
}