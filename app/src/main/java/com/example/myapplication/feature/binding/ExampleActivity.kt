package com.example.myapplication.feature.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityBindingExampleBinding
import com.example.myapplication.feature.binding.example.first.FirstFragment
import com.example.myapplication.feature.binding.example.second.SecondFragment
import com.example.myapplication.feature.binding.example.third.ThirdFragment

class ExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBindingExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_binding_example
        )

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, ThirdFragment())
            .commit()
    }
}

