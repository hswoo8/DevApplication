package com.example.myapplication.feature.motion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import butterknife.ButterKnife
import com.example.myapplication.R

class MotionActivity : AppCompatActivity() {
    private lateinit var container: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val layout1 = intent.getIntExtra("layout_file_id", R.layout.motion_01_basic)
        val layout2 = intent.getIntExtra("layout_file_id", R.layout.motion_)
        val layout3 = intent.getIntExtra("layout_file_id", R.layout.motion_09_coordinatorlayout)
        val layout4 = intent.getIntExtra("layout_file_id", R.layout.motion_09_coordinatorlayout)
        val layout5 = intent.getIntExtra("layout_file_id", R.layout.motion_09_coordinatorlayout)
        val layout6 = intent.getIntExtra("layout_file_id", R.layout.motion_09_coordinatorlayout)
        val layout7 = intent.getIntExtra("layout_file_id", R.layout.motion_09_coordinatorlayout)
        val layout8 = intent.getIntExtra("layout_file_id", R.layout.motion_09_coordinatorlayout)
        val layout9 = intent.getIntExtra("layout_file_id", R.layout.motion_09_coordinatorlayout)
        setContentView(layout1)
//        setContentView(R.layout.motion_01_basic)
        container = findViewById(R.id.content)
        ButterKnife.bind(container)


//        if (layout == R.layout.motion_11_coordinatorlayout) {
//            val icon = findViewById<ImageView>(R.id.icon)
//            icon?.clipToOutline = true
//        }

//        val debugMode = if (intent.getBooleanExtra("showPaths", false)) {
//            MotionLayout.DEBUG_SHOW_PATH
//        } else {
//            MotionLayout.DEBUG_SHOW_NONE
//        }
//        (container as? MotionLayout)?.setDebugMode(debugMode)

    }

//    fun changeState(v: View?) {
//        val motionLayout = container as? MotionLayout ?: return
//        if (motionLayout.progress > 0.5f) {
//            motionLayout.transitionToStart()
//        } else {
//            motionLayout.transitionToEnd()
//        }
//    }
}
