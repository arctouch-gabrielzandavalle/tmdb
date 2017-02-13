package com.arctouch.gabrielzandavalle.tmdb

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by gabrielzandavalle on 1/24/17.
 */
class RxObservableHelper<T> {

  fun unitObservable(func:() -> Unit) : Observable<Unit> {
    return Observable.fromCallable {
      func()
    }.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
  }

  fun listObservable(f:() -> List<T>) : Observable<List<T>> {
    return Observable.fromCallable {
      f()
    }.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
  }

  fun singleModelObservable(func:() -> T?) : Observable<T> {
    return Observable.fromCallable {
      executeFunctionWithPossibleNullValue(func)
    }.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
  }

  private fun executeFunctionWithPossibleNullValue(func:() -> T?) : T {
    val modelValue : T? = func()
    if(modelValue == null) {
      throw Exception("No model found with the given id")
    } else {
      return modelValue
    }
  }
}