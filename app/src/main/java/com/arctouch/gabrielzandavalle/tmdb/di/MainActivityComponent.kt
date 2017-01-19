package com.arctouch.gabrielzandavalle.tmdb.di

import com.arctouch.gabrielzandavalle.tmdb.MainActivity
import dagger.Subcomponent
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by gabrielzandavalle on 1/19/17.
 */

@ActivityScope
@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent{

  fun inject(activity: MainActivity)
}

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScope
