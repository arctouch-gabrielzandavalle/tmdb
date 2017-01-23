package com.arctouch.gabrielzandavalle.tmdb

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arctouch.gabrielzandavalle.tmdb.adapter.MovieAdapter
import com.arctouch.gabrielzandavalle.tmdb.di.MainActivityModule
import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import com.arctouch.gabrielzandavalle.tmdb.model.MovieListResponse
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.view.detail_overview
import kotlinx.android.synthetic.main.fragment_home.moviesRecyclerView
import kotlinx.android.synthetic.main.movie_item.view.movieName
import kotlinx.android.synthetic.main.movie_item.view.posterPath
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by gabrielzandavalle on 1/20/17.
 */
class DetailFragment : Fragment() {

  val TAG = DetailFragment::class.java.name

  @Inject
  lateinit var retrofit: Retrofit

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    super.onCreateView(inflater, container, savedInstanceState)

    initConfiguration()

    val view =  inflater.inflate(R.layout.fragment_detail, container, false)
    val movieId: String = activity.intent.extras.get("selectedMovie") as String

    if (movieId != null) {

      val tmbdApi = retrofit.create(TmdbApiInterface::class.java)
      val movie: Call<Movie> = tmbdApi.getMovie(movieId, "1f54bd990f1cdfb230adb312546d765d")
      movie.enqueue(object: Callback<Movie> {

        override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
          val movie = response?.body()
          if (movie != null) {
            view.movieName.text = movie.title
            view.detail_overview.text = movie.overview
            Picasso.with(activity).load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
                .into(view.posterPath)
          }
        }

        override fun onFailure(call: Call<Movie>?, t: Throwable?) {
          Log.d(TAG, t?.message)
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