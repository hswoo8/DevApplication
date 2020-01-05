package com.example.myapplication.feature.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.databinding.library.baseAdapters.BR
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityBindingExampleBinding
import com.example.myapplication.feature.binding.generic.GenericClass

class ExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBindingExampleBinding

    var text = "123"
    val textObservable = ObservableField<String>("123")
    val observableInt = ObservableInt(123)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_binding_example
        )
        binding.textObservable = textObservable
        binding.stringValue = GenericClass("abc")
    }
}
