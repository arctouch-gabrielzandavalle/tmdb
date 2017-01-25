package com.arctouch.gabrielzandavalle.tmdb.detail

import android.util.Log
import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by gabrielzandavalle on 1/25/17.
 */
class DetailPresenter(val detailView: DetailView, val tmdbApi: TmdbApiInterface) {

  val TAG = DetailPresenter::class.java.name

  fun showMovieDetail(movieId: String) {
    val movie: Observable<Movie> = tmdbApi.getMovie(movieId, "1f54bd990f1cdfb230adb312546d765d")
    movie.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(object: Subscriber<Movie>(){
          override fun onCompleted() {
            //Completed
          }
          override fun onError(e: Throwable) {
            Log.d(TAG, e.message)
          }
          override fun onNext(movie: Movie?) {

            if (movie != null) {
              Log.e("Output",movie.toString());
              detailView.showMovieDetail(movie)
            }
          }
        })
  }
}