package com.arctouch.gabrielzandavalle.tmdb.di

import com.arctouch.gabrielzandavalle.tmdb.detail.DetailViewComponent
import com.arctouch.gabrielzandavalle.tmdb.detail.DetailViewModule
import com.arctouch.gabrielzandavalle.tmdb.home.HomeViewComponent
import com.arctouch.gabrielzandavalle.tmdb.home.HomeViewModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by gabrielzandavalle on 1/19/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface ApplicationComponent {
  fun plus(module: HomeViewModule): HomeViewComponent
  fun plus(module: DetailViewModule): DetailViewComponent
}