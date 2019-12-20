package com.example.myapplication.feature.crop

import android.graphics.Matrix
import android.graphics.PointF
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapplication.PinchImageView
import com.example.myapplication.R
import com.example.myapplication.util.RectUtils

class CropActivity : AppCompatActivity() {

    private var initializeCorner = FloatArray(8)
    private var currentImageCorners = FloatArray(8)
    private val touchCenterPoint = PointF()
    @BindView(R.id.pinch_image_view)
    lateinit var pinchImageView: PinchImageView

    @BindView(R.id.image_view)
    lateinit var imageView: ImageView

    @BindView(R.id.overlay_view)
    lateinit var overlayView: View

    @BindView(R.id.image_view2)
    lateinit var imageView2: ImageView

    val currentImageMatrix = Matrix()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crop)
        ButterKnife.bind(this)

        overlayView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            val intrinsicWidth = imageView.drawable.intrinsicWidth.toFloat()
            val intrinsicHeight = imageView.drawable.intrinsicHeight.toFloat()
            val src = RectF(0f, 0f, intrinsicWidth, intrinsicHeight)
            val dst = RectF(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat())
            val scale = Math.max(
                overlayView.width / intrinsicWidth,
                overlayView.height / intrinsicHeight
            )
            currentImageMatrix.postScale(scale, scale)

            currentImageMatrix.postTranslate(
                -Math.abs(intrinsicWidth * scale - overlayView.width) / 2f + dst.left,
                dst.top - (intrinsicWidth * scale) / 2f + overlayView.height / 2f
            )

            currentImageMatrix.mapPoints(currentImageCorners, initializeCorner)
            imageView.imageMatrix = currentImageMatrix

        }

        imageView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            val intrinsicWidth = imageView.drawable.intrinsicWidth.toFloat()
            val intrinsicHeight = imageView.drawable.intrinsicHeight.toFloat()
            initializeCorner = RectUtils.getCornersFromRect(
                RectF(
                    left.toFloat(),
                    top.toFloat(),
                    intrinsicWidth,
                    intrinsicHeight
                )
            )
            currentImageMatrix.mapPoints(initializeCorner)
        }


        val scaleGestureDetector = ScaleGestureDetector(
            baseContext,
            object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                override fun onScale(detector: ScaleGestureDetector?): Boolean {
                    val rectF = RectF(
                        overlayView.left.toFloat(),
                        overlayView.top.toFloat(),
                        overlayView.right.toFloat(),
                        overlayView.bottom.toFloat()
                    )

                    if ((detector!!.scaleFactor < 1)) {
                        if (!RectUtils.trapToRect(currentImageCorners).contains(rectF)) {
                            return true
                        }
                    }
                    val scaleMatrix = Matrix(currentImageMatrix)
                        .apply {
                            postScale(
                                detector!!.scaleFactor,
                                detector!!.scaleFactor,
                                touchCenterPoint.x,
                                touchCenterPoint.y
                            )
                        }

                    val expectedCorners = FloatArray(8)
                    scaleMatrix.mapPoints(expectedCorners, initializeCorner)

                    if (RectUtils.trapToRect(expectedCorners).contains(rectF)) {
                        currentImageMatrix.set(scaleMatrix)
                        imageView.imageMatrix = currentImageMatrix
                    }

                    return true
                }
            })
        val gestureDetector =
            GestureDetector(baseContext, object : GestureDetector.SimpleOnGestureListener() {
                override fun onScroll(
                    e1: MotionEvent?,
                    e2: MotionEvent?,
                    distanceX: Float,
                    distanceY: Float
                ): Boolean {
                    if (distanceX != 0f || distanceY != 0f) {
                        val overlay = RectF(
                            overlayView.left.toFloat(),
                            overlayView.top.toFloat(),
                            overlayView.right.toFloat(),
                            overlayView.bottom.toFloat()
                        )
                        val xTransition = Matrix(currentImageMatrix)
                        val expectedCorner = FloatArray(8)

                        xTransition.postTranslate(-distanceX, 0f)
                        xTransition.mapPoints(expectedCorner, initializeCorner)
                        if (RectUtils.trapToRect(expectedCorner).contains(overlay)) {
                            currentImageMatrix.postTranslate(-distanceX, 0f)
                        }

                        val yTransition = Matrix(currentImageMatrix)
                        yTransition.postTranslate(0f, -distanceY)
                        yTransition.mapPoints(expectedCorner, initializeCorner)
                        if (RectUtils.trapToRect(expectedCorner).contains(overlay)) {
                            currentImageMatrix.postTranslate(0f, -distanceY)
                        }

                        currentImageMatrix.mapPoints(currentImageCorners, initializeCorner)
                        imageView.imageMatrix = currentImageMatrix
                    }
                    return true
                }
            })

        imageView.setOnTouchListener { v, event ->
            if (event.pointerCount > 1) {
                val centerX = (event.getX(0) + event.getX(1)) / 2
                val centerY = (event.getY(0) + event.getY(1)) / 2
                touchCenterPoint.set(centerX, centerY)
            }

            gestureDetector.onTouchEvent(event)
            scaleGestureDetector.onTouchEvent(event)

            true
        }
    }
}
