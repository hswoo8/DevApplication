package com.example.myapplication.feature.binding

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter


object ImageViewBindingAdapter {
    @BindingAdapter("android:alpha", "android:src", requireAll = true)
    @JvmStatic
    fun setImage(imageView: ImageView, alpha: Float, drawable: Drawable) {
        Log.d("seoungwoo --", "setimage")
        imageView.alpha = alpha
        imageView.setImageDrawable(drawable)
    }
}