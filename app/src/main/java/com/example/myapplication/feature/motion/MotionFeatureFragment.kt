package com.example.myapplication.feature.motion

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.NestedScrollingParent2
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import butterknife.ButterKnife
import com.example.myapplication.R
import com.example.myapplication.feature.motion.utils.CollapsibleToolbar
import com.example.myapplication.feature.motion.utils.TouchFrameLayout
import com.example.myapplication.feature.motion.utils.ViewPagerAdapter
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.motion_23_viewpager.*

class MotionFeatureFragment : Fragment(), MotionActivity.TransitionListener {
    override fun onShow() {
        view?.run {
            visibility = View.VISIBLE
        }
    }

    override fun onHide() {
        view?.run {
            visibility = View.GONE
        }
    }

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
            10 -> R.layout.motion_10_coordinatorlayout
            14 -> R.layout.motion_14_side_panel
            15 -> R.layout.motion_15_parallax
            23 -> R.layout.motion_23_viewpager
            17 -> R.layout.motion_17_coordination
            else -> R.layout.motion_01_basic
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
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

        if (chapter == 9) {
            val header = view.findViewById<CollapsibleToolbar>(R.id.motionLayout)
            val scrollView = view.findViewById<NestedScrollView>(R.id.scrollable)
            val appbar = view.findViewById<AppBarLayout>(R.id.app_bar)

            header.callBack = object : CollapsibleToolbar.CallBack {
                override fun canScroll(): Boolean {
                    return scrollView.canScrollVertically(-1)
                }
            }
        }
    }
}