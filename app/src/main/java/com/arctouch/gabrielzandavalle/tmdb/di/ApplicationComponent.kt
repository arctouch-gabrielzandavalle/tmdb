package com.arctouch.gabrielzandavalle.tmdb.di

import com.arctouch.gabrielzandavalle.tmdb.TmdbApplication
import dagger.Component
import javax.inject.Singleton

/**
 * Created by gabrielzandavalle on 1/19/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface ApplicationComponent {
  fun plus(module: MainActivityModule): MainActivityComponent
}
