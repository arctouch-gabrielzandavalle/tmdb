package com.arctouch.gabrielzandavalle.tmdb.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by gabrielzandavalle on 1/17/17.
 */

 data class Movie(
    val id: String = "",
    @com.google.gson.annotations.SerializedName("poster_path")
    val posterPath: String = "",
    val title: String = "",
    val overview: String = ""
  ): Parcelable {

  companion object {
    @JvmField val CREATOR: Parcelable.Creator<Movie> = object: Parcelable.Creator<Movie> {
      override fun createFromParcel(source: Parcel): Movie = Movie(source)
      override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
    }
  }

  constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString())

  override fun describeContents() = 0

  override fun writeToParcel(dest: Parcel?, flags: Int) {
    dest?.writeString(id)
    dest?.writeString(posterPath)
    dest?.writeString(title)
    dest?.writeString(overview)
  }
}