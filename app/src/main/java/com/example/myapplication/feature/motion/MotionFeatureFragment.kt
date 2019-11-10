package com.example.myapplication.feature.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import butterknife.ButterKnife
import com.example.myapplication.R
import com.example.myapplication.feature.motion.utils.ViewPagerAdapter
import kotlinx.android.synthetic.main.motion_23_viewpager.*

class MotionFeatureFragment : Fragment() {

    private var chapter: Int = 0

    companion object {
        const val KEY_NUM_CHAPTER = "keyNumChapter"
        const val TAG = "MotionFeatureFragment"
        @JvmStatic
        fun newInstance(chapter: Int): Fragment {
            val motionFeatureFragment = MotionFeatureFragment()
            motionFeatureFragment.arguments = Bundle().also { it.putInt(KEY_NUM_CHAPTER, chapter) }
            return motionFeatureFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chapter = arguments?.getInt(KEY_NUM_CHAPTER, 1) ?: 1
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getMotionLayout(chapter), container, false)
    }

    private fun getMotionLayout(chapter: Int): Int {
        return when (chapter) {
            1 -> R.layout.motion_01_basic
            2 -> R.layout.motion_02
            3 -> R.layout.motion_03
            4 -> R.layout.motion_04_custom_attribute
            5 -> R.layout.motion_05_imagefilter
            6 -> R.layout.motion_06_keyframe
            7 -> R.layout.motion_07_keyframe
            8 -> R.layout.motion_08_cycle
            9 -> R.layout.motion_09_coordinatorlayout
            14 -> R.layout.motion_14_side_panel
            15 -> R.layout.motion_15_parallax
            23 -> R.layout.motion_23_viewpager
            else -> R.layout.motion_01_basic
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)

        if (chapter == 23) {
            val motionLayout = getView()!!.findViewById<MotionLayout>(R.id.motionLayout)

            val adapter = ViewPagerAdapter(childFragmentManager)
            adapter.addPage("Page 1", R.layout.motion_16_viewpager_page1)
            adapter.addPage("Page 2", R.layout.motion_16_viewpager_page2)
            adapter.addPage("Page 3", R.layout.motion_16_viewpager_page3)
            pager.adapter = adapter
            tabs.setupWithViewPager(pager)
            if (motionLayout != null) {
                pager.addOnPageChangeListener(motionLayout as ViewPager.OnPageChangeListener)
            }

            val b = arguments?.getBoolean("showPaths", false) ?: false
            val debugMode = if (b) {
                MotionLayout.DEBUG_SHOW_PATH
            } else {
                MotionLayout.DEBUG_SHOW_NONE
            }
            motionLayout.setDebugMode(debugMode)
        }

    }
}