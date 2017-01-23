package com.arctouch.gabrielzandavalle.tmdb

import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arctouch.gabrielzandavalle.tmdb.di.MainActivityModule
import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.view.detail_overview
import kotlinx.android.synthetic.main.fragment_detail.view.releaseDate
import kotlinx.android.synthetic.main.movie_item.view.movieName
import kotlinx.android.synthetic.main.movie_item.view.posterPath
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by gabrielzandavalle on 1/20/17.
 */
class DetailFragment : Fragment() {

  val TAG = DetailFragment::class.java.name

  @Inject
  lateinit var tmdbApi: TmdbApiInterface

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    super.onCreateView(inflater, container, savedInstanceState)

    initConfiguration()

    val view =  inflater.inflate(R.layout.fragment_detail, container, false)
    val movieId: String = activity.intent.extras.get("selectedMovie") as String

    if (movieId != null) {

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
                Log.e("Output",movie?.toString());

                view.movieName.text = movie.title
                view.detail_overview.text = movie.overview
                view.releaseDate.text = movie.releaseDate
                Picasso.with(activity).load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
                    .into(view.posterPath)
              }
            }
          })
    }
    return view
  }

  private fun initConfiguration() {
    TmdbApplication.get(this.activity)
        .applicationComponent
        .plus(MainActivityModule())
        .inject(this)
  }
}