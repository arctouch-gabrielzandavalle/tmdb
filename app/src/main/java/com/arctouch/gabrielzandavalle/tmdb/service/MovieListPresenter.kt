package com.arctouch.gabrielzandavalle.tmdb.service

import android.util.Log
import com.arctouch.gabrielzandavalle.tmdb.MovieListView
import com.arctouch.gabrielzandavalle.tmdb.model.MovieListResponse
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by gabrielzandavalle on 1/24/17.
 */

class MovieListPresenter(val view: MovieListView, val tmdbApi: TmdbApiInterface) {

  val TAG = MovieListPresenter::class.java.name

  fun showMovieList() {

    val list: Observable<MovieListResponse> = tmdbApi.getList("1", "1f54bd990f1cdfb230adb312546d765d")

    list.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe (object: Subscriber<MovieListResponse>(){
          override fun onCompleted() {
            //Completed
          }

          override fun onError(e: Throwable) {
            Log.d(TAG, e.message)
          }

          override fun onNext(response: MovieListResponse?) {
            Log.e("Output",response.toString());

            view.loadMovies(response?.items!!)
          }
        })
  }
}