package com.arctouch.gabrielzandavalle.tmdb

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.action.ViewActions.click
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.filters.LargeTest
import com.arctouch.gabrielzandavalle.tmdb.adapter.MovieAdapter
import org.junit.runner.RunWith
import org.junit.Rule
import org.junit.Test
import android.support.test.espresso.Espresso

/**
 * Created by gabrielzandavalle on 1/31/17.
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class SelectMovieTest {

  @Rule @JvmField
  val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

  @Test
  fun testSelectMovie() {
    val onView = onView(withId(R.id.moviesRecyclerView))
    val idlingResource = ElapsedTimeIdlingResource(1000)
    Espresso.registerIdlingResources(idlingResource)
    onView.perform(RecyclerViewActions
        .actionOnItemAtPosition<MovieAdapter.ViewHolder>(0, click()))
  }
}