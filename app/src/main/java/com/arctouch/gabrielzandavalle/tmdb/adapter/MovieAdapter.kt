package com.arctouch.gabrielzandavalle.tmdb.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arctouch.gabrielzandavalle.tmdb.R
import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.movieName

/**
 * Created by gabrielzandavalle on 1/17/17.
 */

class MovieAdapter(movies: List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

  private var movies: List<Movie> = movies

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    return ViewHolder(layoutInflater.inflate(R.layout.movie_item, parent, false))
  }

  override fun getItemCount(): Int {
    return movies.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = movies[position]
    holder.movieName.text = item.title;
  }

  class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val movieName: TextView = view.movieName
  }
}
