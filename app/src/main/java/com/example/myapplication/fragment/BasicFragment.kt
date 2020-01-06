package com.example.myapplication.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentBasicBinding

class BasicFragment() : AbstractFragment(R.layout.fragment_basic) {
    private lateinit var binding: FragmentBasicBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasicBinding.inflate(layoutInflater, container, false)

        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_basic,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBasicBinding.bind(view) ?: return

    }


    companion object {
        const val TAG = "basicFragment"
        fun newInstance(): BasicFragment {
            return BasicFragment()
        }
    }
}