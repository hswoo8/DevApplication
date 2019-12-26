package com.example.myapplication.feature.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.recyclerview.widget.RecyclerView
@BindingMethods(
    BindingMethod(
        type = RecyclerView::class,
        attribute = "setHasFixedSize",
        method = "setHasFixedSize"
    )
)
object RecyclerViewBindingAdapter {

}