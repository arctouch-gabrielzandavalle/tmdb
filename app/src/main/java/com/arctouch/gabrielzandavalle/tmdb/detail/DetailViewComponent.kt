package com.arctouch.gabrielzandavalle.tmdb.detail

import com.arctouch.gabrielzandavalle.tmdb.di.ActivityScope
import dagger.Subcomponent

/**
 * Created by gabrielzandavalle on 1/25/17.
 */

@ActivityScope
@Subcomponent(modules = arrayOf(DetailViewModule::class))
interface DetailViewComponent {
  fun inject(detailFragment: DetailFragment)
}