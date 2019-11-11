package com.example.myapplication.feature.motion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.myapplication.R
import com.example.myapplication.feature.motion.utils.TouchFrameLayout
import java.lang.Exception

class MotionActivity : AppCompatActivity(), MotionLayout.TransitionListener {

    @BindView(R.id.chapter_input)
    lateinit var input: EditText

    @BindView(R.id.checkbox)
    lateinit var animatable: CheckBox

    @BindView(R.id.fragment_container)
    lateinit var fragmentContainer: FrameLayout

    @BindView(R.id.container1)
    lateinit var container: TouchFrameLayout

    @BindView(R.id.motionLayout1)
    lateinit var motionLayout: MotionLayout

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

        animatable.setOnClickListener {
            (it as CompoundButton).run {
                if (it.isChecked) {
                    motionLayout.visibility = View.VISIBLE
                    fragmentContainer.visibility = View.GONE
                } else {
                    motionLayout.visibility = View.GONE
                    fragmentContainer.visibility = View.VISIBLE
                }
            }
        }


        (container.parent as MotionLayout).setTransitionListener(this)

        (motionLayout.layoutParams as ConstraintLayout.LayoutParams).run {
            this.topToTop = R.id.enter
            this.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            motionLayout.layoutParams = this
        }
    }

    private var lastProgress = 0f

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

    }

    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

    }

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
        Log.d("seoungwoo -- ", "p1($p1), p2($p2), p3($p3)")
        val delta = p3 - lastProgress
        if (delta > 0) {
            val atEnd = Math.abs(p3 - 1f) < 0.1f
            if (atEnd) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setCustomAnimations(R.animator.show, 0)
                transaction.replace(
                    R.id.container1,
                    MotionFeatureFragment.newInstance(input.text.toString().toInt()),
                    MotionFeatureFragment.TAG
                ).commitNow()
            }
        } else {
            val findFragmentByTag =
                supportFragmentManager.findFragmentByTag(MotionFeatureFragment.TAG)
            (findFragmentByTag as? TransitionListener)?.run {
                this.onHide()
            }
        }
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {

    }

    interface TransitionListener {
        fun onShow()
        fun onHide()
    }
}
