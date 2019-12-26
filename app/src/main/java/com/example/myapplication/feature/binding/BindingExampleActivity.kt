package com.example.myapplication.feature.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityBindingExampleBinding

class BindingExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView = DataBindingUtil.setContentView<ActivityBindingExampleBinding>(
            this,
            R.layout.activity_binding_example
        )

        TEXT

        val b = true

        View.VISIBLE
    }
}
