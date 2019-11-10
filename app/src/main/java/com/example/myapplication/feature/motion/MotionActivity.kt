package com.example.myapplication.feature.motion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter
import com.example.myapplication.R
import java.lang.Exception

class MotionActivity : AppCompatActivity() {

    @BindView(R.id.chapter_input)
    lateinit var input: EditText

    @OnClick(R.id.enter)
    fun onClickEnter() {
        val text = input.text.toString()
        input.text = null


        try {
            Integer.parseInt(text)
        } catch (e: Exception) {
            Toast.makeText(this, "Only Available Digit", Toast.LENGTH_SHORT).show()
            return
        }
        
        val beginTransaction = supportFragmentManager.beginTransaction()
        if (supportFragmentManager.findFragmentByTag(MotionFeatureFragment.TAG) != null) {
            beginTransaction.remove(supportFragmentManager.findFragmentByTag(MotionFeatureFragment.TAG)!!)
        }



        beginTransaction
            .add(
                R.id.fragment_container,
                MotionFeatureFragment.newInstance(text.toInt()),
                MotionFeatureFragment.TAG
            )
            .commitNowAllowingStateLoss()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion)
        ButterKnife.bind(this)
    }
}
