package com.example.myapplication.feature.motion.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.NestedScrollingParent2
import java.util.jar.Attributes
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class TouchFrameLayout : FrameLayout, NestedScrollingParent2 {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributes: AttributeSet?) : super(context, attributes, 0)

    fun getMotionLayout(): NestedScrollingParent2 {
        return parent as NestedScrollingParent2
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        getMotionLayout().onNestedPreScroll(target, dx, dy, consumed, type)
    }

    override fun onStopNestedScroll(target: View, type: Int) {
        getMotionLayout().onStopNestedScroll(target, type)
    }

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        return getMotionLayout().onStartNestedScroll(child, target, axes, type)
    }

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) {
        getMotionLayout().onNestedScrollAccepted(child, target, axes, type)
    }

    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
        getMotionLayout().onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)
    }
}