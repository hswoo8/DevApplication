package com.example.myapplication.feature.binding

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.widget.DrawableUtils
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.databinding.InverseBindingAdapter
import com.example.myapplication.feature.binding.generic.ValueClass


object ImageViewBindingAdapter {

    @BindingAdapter("android:src", "setValue", requireAll = false)
    @JvmStatic
    fun setImage(imageView: ImageView, resId: Int, value: ValueClass?) {
        val drawable = imageView.context.getDrawable(resId)
        value?.value = 24
        imageView.setImageDrawable(drawable)
    }

    @BindingAdapter("pressed")
    @JvmStatic
    fun setPressed(imageView: ImageView, pressed: Boolean) {
        imageView.isPressed = pressed
    }

//    @BindingAdapter("setValue")
//    @JvmStatic
//    fun setValue(imageView: ImageView, value: ValueClass) {
//        value.value = 20
//    }

    @BindingAdapter("android:alpha", "android:src", requireAll = true)
    @JvmStatic
    fun setImage(imageView: ImageView, alpha: Float, drawable: Drawable) {
        imageView.alpha = alpha
        imageView.setImageDrawable(drawable)
    }


}