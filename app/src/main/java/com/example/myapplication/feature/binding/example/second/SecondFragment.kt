package com.example.myapplication.feature.binding.example.second

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentSecondExampleBinding
import com.example.myapplication.feature.binding.example.BaseFragment
import com.example.myapplication.feature.binding.example.Model


class SecondFragment : BaseFragment() {
    private lateinit var binding: FragmentSecondExampleBinding
    private lateinit var viewModel: ViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondExampleBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModel()
        binding.viewModel = viewModel
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed(Runnable {
        }, 1000)
    }
}