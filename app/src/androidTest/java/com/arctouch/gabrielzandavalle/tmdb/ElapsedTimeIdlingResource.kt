package com.arctouch.gabrielzandavalle.tmdb

import android.support.test.espresso.IdlingResource.ResourceCallback
import android.support.test.espresso.IdlingResource

/**
 * Created by gabrielzandavalle on 2/6/17.
 */

class ElapsedTimeIdlingResource(private val waitingTime: Long): IdlingResource {
  private val startTime: Long
  private var resourceCallback: ResourceCallback? = null

  init {
    this.startTime = System.currentTimeMillis()
  }

  override fun getName(): String {
    return ElapsedTimeIdlingResource::class.java.name + ":" + waitingTime
  }

  override fun isIdleNow(): Boolean {
    val elapsed = System.currentTimeMillis() - startTime
    val idle = elapsed >= waitingTime
    if (idle) {
      resourceCallback!!.onTransitionToIdle()
    }
    return idle
  }

  override fun registerIdleTransitionCallback(resourceCallback: ResourceCallback) {
    this.resourceCallback = resourceCallback
  }
}