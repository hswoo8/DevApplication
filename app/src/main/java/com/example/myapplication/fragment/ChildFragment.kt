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

class ChildFragment : AbstractFragment(R.layout.fragment_basic) {

    override var TAG: String = "ChildFragment"

    @BindView(R.id.text_view)
    lateinit var textView: TextView

    companion object {
        fun newInstance(tag: String = ""): ChildFragment {
            return ChildFragment().apply {
                val string = if (tag.isEmpty()) TAG else tag
                arguments = Bundle().apply { putString(FragmentConst.KEY_TAG, string) }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val onCreateView = super.onCreateView(inflater, container, savedInstanceState)
        onCreateView?.tag = "AAA"
        return onCreateView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
        Log.d("seoungwoo -- ", "child fragment tag = $tag")
        textView.text = tag

    }
}