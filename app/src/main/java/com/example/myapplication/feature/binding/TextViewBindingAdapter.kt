package com.example.myapplication.feature.binding

import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.example.myapplication.feature.binding.generic.GenericClass

object TextViewBindingAdapter {
    @BindingAdapter("text1")
    @JvmStatic
    fun setText(textView: TextView, string: ObservableField<String>) {
        Log.d("seoungwoo -- ", "setText")
    }



    @BindingAdapter("text1")
    @JvmStatic
    fun setText(textView: TextView, value: GenericClass<String>) {
        Log.d("seoungwoo -- ", "setText Generic Class")
        textView.setText(value.t)
    }

}