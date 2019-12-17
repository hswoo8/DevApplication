package com.example.myapplication.fragment

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
        Log.d("seoungwoo -- ", "child fragment tag = $tag")
        textView.text = "$tag ${fragmentManager!!.fragments.size}"

    }
}