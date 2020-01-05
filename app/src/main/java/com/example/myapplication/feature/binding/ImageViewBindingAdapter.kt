package com.example.myapplication.feature.binding

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter


object ImageViewBindingAdapter {

    @BindingAdapter("android:src")
    @JvmStatic
    fun setImage(imageView: ImageView, resId: Int) {
        val drawable = imageView.context.getDrawable(resId)
        imageView.setImageDrawable(drawable)
    }

    @BindingAdapter("android:alpha", "android:src", requireAll = true)
    @JvmStatic
    fun setImage(imageView: ImageView, alpha: Float, drawable: Drawable) {
        imageView.alpha = alpha
        imageView.setImageDrawable(drawable)
    }
}