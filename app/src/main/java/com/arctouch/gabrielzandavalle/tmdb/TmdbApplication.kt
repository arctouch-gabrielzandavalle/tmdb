package com.arctouch.gabrielzandavalle.tmdb

import android.app.Application
import android.content.Context
import com.arctouch.gabrielzandavalle.tmdb.di.AppModule
import com.arctouch.gabrielzandavalle.tmdb.di.ApplicationComponent
import com.arctouch.gabrielzandavalle.tmdb.di.DaggerApplicationComponent

/**
 * Created by gabrielzandavalle on 1/19/17.
 */
class TmdbApplication : Application() {

  var applicationComponent: ApplicationComponent = DaggerApplicationComponent
      .builder()
      .appModule(AppModule(this))
      .build()

  companion object Factory {
    fun get(context: Context): TmdbApplication {
      return context.applicationContext as TmdbApplication
    }
  }
}