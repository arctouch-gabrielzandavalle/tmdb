package com.arctouch.gabrielzandavalle.tmdb.detail

import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import dagger.Module
import dagger.Provides

/**
 * Created by gabrielzandavalle on 1/25/17.
 */

@Module
class DetailViewModule(val detailView: DetailView) {

  @Provides
  fun provideDetailPresenter(tmdbApi: TmdbApiInterface) : DetailPresenter {
    return DetailPresenter(detailView, tmdbApi)
  }
}