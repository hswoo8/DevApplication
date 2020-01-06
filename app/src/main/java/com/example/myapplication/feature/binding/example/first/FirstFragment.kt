package com.example.myapplication.feature.binding.example.first

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFirstExampleBinding
import com.example.myapplication.feature.binding.example.BaseFragment
import com.example.myapplication.feature.binding.example.Model
import com.example.myapplication.feature.binding.example.Repository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiConsumer
import java.util.function.Consumer

class FirstFragment : BaseFragment() {
    private lateinit var binding: FragmentFirstExampleBinding
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstExampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModel()
        binding.viewModel = viewModel
    }
}
