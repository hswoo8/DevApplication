package com.example.myapplication.feature.binding

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter

object ViewBindingAdapter1 {
    @BindingAdapter("visibility")
    @JvmStatic
    fun setVisibility(view: View, visibility: Int) {
        view.visibility = visibility
    }
}