package com.arctouch.gabrielzandavalle.tmdb.di

import com.arctouch.gabrielzandavalle.tmdb.TmdbApplication
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by gabrielzandavalle on 1/18/17.
 */

@Module
class AppModule(private val tmdbApplication: TmdbApplication) {

  @Provides @Singleton
  fun provideApplication() : TmdbApplication{
    return tmdbApplication;
  }

  @Provides
  fun provideRetrofitBaseUrl() : String {
    return "https://api.themoviedb.org/3/"
  }

  @Provides @Singleton
  fun provideRetrofit(retrofitBaseUrl: String) : Retrofit {
    return Retrofit.Builder()
        .baseUrl(retrofitBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }
}
