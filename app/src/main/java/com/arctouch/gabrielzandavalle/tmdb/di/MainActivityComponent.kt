package com.arctouch.gabrielzandavalle.tmdb.di

import com.arctouch.gabrielzandavalle.tmdb.DetailFragment
import com.arctouch.gabrielzandavalle.tmdb.HomeFragment
import com.arctouch.gabrielzandavalle.tmdb.MainActivity
import dagger.Subcomponent

/**
 * Created by gabrielzandavalle on 1/19/17.
 */

@ActivityScope
@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent{

  fun inject(activity: MainActivity)

  //criar classes separadas.
  fun inject(activity: HomeFragment)
  fun inject(detailFragment: DetailFragment)
}
