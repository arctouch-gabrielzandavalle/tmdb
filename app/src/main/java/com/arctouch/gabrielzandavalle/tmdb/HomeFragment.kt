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
import com.arctouch.gabrielzandavalle.tmdb.model.MovieListResponse
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import kotlinx.android.synthetic.main.fragment_home.moviesRecyclerView
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by gabrielzandavalle on 1/19/17.
 */
class HomeFragment : Fragment() {

  val TAG = MainActivity::class.java.name

  @Inject
  lateinit var tmdbApi: TmdbApiInterface

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    super.onCreateView(inflater, container, savedInstanceState)

    val view = inflater.inflate(R.layout.fragment_home, container, false)

    initConfiguration()

    val list: Observable<MovieListResponse> = tmdbApi.getList("1", "1f54bd990f1cdfb230adb312546d765d")

    list.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe (object:Subscriber<MovieListResponse>(){
          override fun onCompleted() {
            //Completed
          }

          override fun onError(e: Throwable) {
           Log.d(TAG, e.message)
          }

          override fun onNext(response: MovieListResponse?) {
            Log.e("Output",response.toString());

            moviesRecyclerView.adapter = MovieAdapter(response?.items!!)
            moviesRecyclerView.layoutManager = LinearLayoutManager(this@HomeFragment.activity)
          }
        })

    return view
  }

  private fun initConfiguration() {
    TmdbApplication.get(this.activity)
        .applicationComponent
        .plus(MainActivityModule())
        .inject(this)
  }
}