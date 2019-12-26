package com.example.myapplication.feature.binding


import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.R

const val TEXT = "TEXT"

class ImageViewViewModel : ViewModel() {
    val r = MutableLiveData<Int>(R.drawable.avatar_2_raster)
    val visibility = MutableLiveData(View.VISIBLE)
    val value = MutableLiveData(2)


    companion object {
        const val CONST_TEXT: String = "text"
    }

}