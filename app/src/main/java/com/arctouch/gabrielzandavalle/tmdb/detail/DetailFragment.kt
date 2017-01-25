package com.arctouch.gabrielzandavalle.tmdb.detail

import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arctouch.gabrielzandavalle.tmdb.R
import com.arctouch.gabrielzandavalle.tmdb.TmdbApplication
import com.arctouch.gabrielzandavalle.tmdb.home.HomeViewModule
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
class DetailFragment : Fragment(), DetailView {

  @Inject
  lateinit var detailPresenter: DetailPresenter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    super.onCreateView(inflater, container, savedInstanceState)

    initConfiguration()

    val view =  inflater.inflate(R.layout.fragment_detail, container, false)
    val movieId: String = activity.intent.extras.get("selectedMovie") as String

    detailPresenter.showMovieDetail(movieId)
    
    return view
  }

  override fun showMovieDetail(movie: Movie) {
    view.movieName.text = movie.title
    view.detail_overview.text = movie.overview
    view.releaseDate.text = movie.releaseDate
    Picasso.with(activity).load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
        .into(view.posterPath)
  }

  private fun initConfiguration() {
    TmdbApplication.get(this.activity)
        .applicationComponent
        .plus(DetailViewModule(this))
        .inject(this)
  }
}