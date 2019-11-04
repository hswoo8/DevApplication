package com.example.myapplication.feature.motion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter
import com.example.myapplication.R

class MotionActivity : AppCompatActivity() {

    @BindView(R.id.fragment_container)
    lateinit var container: FrameLayout

    @BindView(R.id.chapter_input)
    lateinit var input: EditText

    @OnClick(R.id.enter)
    fun onClickEnter() {
        if (supportFragmentManager.findFragmentByTag(MotionFeatureFragment.TAG) != null) {
            supportFragmentManager.beginTransaction().remove(supportFragmentManager.findFragmentByTag(MotionFeatureFragment.TAG)!!)
                .commitNowAllowingStateLoss()
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MotionFeatureFragment.newInstance(input.text.toString().toInt()), MotionFeatureFragment.TAG)
            .commitNowAllowingStateLoss()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion)
        ButterKnife.bind(this)
    }
}
