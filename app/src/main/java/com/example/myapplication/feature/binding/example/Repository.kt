package com.example.myapplication.feature.binding.example

import android.util.Log
import com.example.myapplication.java.Person
import io.reactivex.Completable
import io.reactivex.CompletableSource
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository(val callBack: Repository.CallBack) {
    interface CallBack {
        fun onLoad(list: List<Model>)
    }

    fun requestNations() {
        val d = Observable.fromCallable {
            Thread.sleep(1000L)
            arrayListOf(
                Model(1, "한국인"),
                Model(2, "미국인"),
                Model(3, "중국인"),
                Model(4, "일본인"),
                Model(5, "대만인")
            )
        }
            .subscribeOn(Schedulers.io())
            .subscribe {
                callBack.onLoad(it)
            }
    }
}

