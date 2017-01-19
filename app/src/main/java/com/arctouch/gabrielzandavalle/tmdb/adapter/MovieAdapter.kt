package com.arctouch.gabrielzandavalle.tmdb.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.arctouch.gabrielzandavalle.tmdb.R
import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.movieName
import kotlinx.android.synthetic.main.movie_item.view.overview
import kotlinx.android.synthetic.main.movie_item.view.posterPath

/**
 * Created by gabrielzandavalle on 1/17/17.
 */

class MovieAdapter(context: Context, movies: List<Movie>): RecyclerView.Adapter<MovieAdapter
.ViewHolder>() {

  private var movies: List<Movie> = movies
  private val context: Context = context

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    return ViewHolder(layoutInflater.inflate(R.layout.movie_item, parent, false))
  }

  override fun getItemCount(): Int {
    return movies.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = movies[position]
    holder.movieName.text = item.title
    holder.overview.text = item.overview
    Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + item.posterPath).into(holder
        .posterPath)
  }

  class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val posterPath: ImageView = view.posterPath
    val movieName: TextView = view.movieName
    val overview: TextView = view.overview
  }
}
