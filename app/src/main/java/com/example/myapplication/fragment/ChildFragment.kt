package com.example.myapplication.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapplication.R

class ChildFragment : AbstractFragment(R.layout.fragment_basic) {

    override var TAG: String = "ChildFragment"

    @BindView(R.id.text_view)
    lateinit var textView: TextView

    companion object {
        fun newInstance(size: Int = 0): ChildFragment {
            return ChildFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("seoungwoo -- ", "oncreateview$tag")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
        Log.d("seoungwoo -- ", "child fragment tag = $tag")
        textView.text = "$tag ${fragmentManager!!.fragments.size}"

    }

    override fun onAttach(context: Context) {
        Log.d("seoungwoo -- ", "onAttach$tag")
        super.onAttach(context)
    }

    override fun onStart() {
        Log.d("seoungwoo -- ", "onStart$tag")
        super.onStart()
    }

    override fun onResume() {
        Log.d("seoungwoo -- ", "onResume$tag")
        super.onResume()
    }

    override fun onPause() {
        Log.d("seoungwoo -- ", "onPause$tag")
        super.onPause()
    }

    override fun onStop() {
        Log.d("seoungwoo -- ", "onStop$tag")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("seoungwoo -- ", "onDestroyView$tag")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("seoungwoo -- ", "onDestroy$tag")
        super.onDestroy()
    }
}