package com.example.myapplication.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapplication.R

class BasicFragment() : Fragment(R.layout.fragment_basic) {

    companion object {
        const val TAG = "basicFragment"
        fun newInstance(): BasicFragment {
            return BasicFragment()
        }
    }

    @BindView(R.id.text_view)
    lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val onCreateView = super.onCreateView(inflater, container, savedInstanceState)
        ButterKnife.bind(this, onCreateView!!)
        return onCreateView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("seoungwoo -- ", "tag = $tag")
    }


}