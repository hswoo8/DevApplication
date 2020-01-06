package com.example.myapplication.feature.binding.example.second

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData

import com.example.myapplication.BaseApplication
import com.example.myapplication.R
import com.example.myapplication.feature.binding.example.Model
import com.example.myapplication.feature.binding.example.Repository
import com.example.myapplication.feature.binding.generic.ValueClass

class ViewModel() : BaseObservable(), Repository.CallBack {
    var resId = R.drawable.avatar_2_raster
    val repository = Repository(this)
    val pressed = ObservableBoolean(false)

    init {
        repository.requestNations()
    }

    @get:Bindable
    var text = "Welcome, Data Binding"
        set(value) {
            field = value
            notifyPropertyChanged(BR.text)
        }

    override fun onLoad(list: List<Model>) {

    }
}

