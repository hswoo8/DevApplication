package com.example.myapplication.feature.binding.example.first

import android.app.Application
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.BaseApplication
import com.example.myapplication.R
import com.example.myapplication.feature.binding.example.Model
import com.example.myapplication.feature.binding.example.Repository

class ViewModel() : Repository.CallBack {
    val repository = Repository(this)

    init {
        repository.requestNations()
    }

    var resId = R.drawable.avatar_2_raster
    var tintMode = PorterDuff.Mode.MULTIPLY
    var tint = ColorStateList.valueOf(
        ContextCompat.getColor(
            BaseApplication.context,
            R.color.colorPrimary
        )
    )
    var drawable = ContextCompat.getDrawable(
        BaseApplication.context,
        R.drawable.avatar_8_raster
    )

    var text = ObservableField("Welcome, Data Binding")

    override fun onLoad(list: List<Model>) {

        text.set(list.firstOrNull()?.place ?: "")
    }
}




