package com.example.myapplication.feature.crop

import android.graphics.Matrix
import android.graphics.PointF
import android.graphics.Rect
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
import kotlinx.android.synthetic.main.layout_item_view.view.*

class CropActivity : AppCompatActivity() {

    private var initializeCorner = FloatArray(8)
    private var currentImageCorners = FloatArray(8)
    private val touchCenterPoint = PointF()
    @BindView(R.id.pinch_image_view)
    lateinit var pinchImageView: PinchImageView
    @BindView(R.id.image_view1)
    lateinit var imageView1: ImageView

    @BindView(R.id.overlay_view)
    lateinit var overlayView: View

    @BindView(R.id.image_view2)
    lateinit var imageView2: ImageView

    val currentImageMatrix = Matrix()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crop)
        ButterKnife.bind(this)

        pinchImageView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            Log.d("seoungwoo -- ", "v.width(${v.width}), v.height(${v.height})")
            val matrix = Matrix()
            pinchImageView.getCurrentImageMatrix(matrix)
            Log.d("seoungwoo -- ", "matrix = $matrix")
            pinchImageView.getOuterMatrix(matrix)
            Log.d("seoungwoo -- ", "matrix = $matrix")
            pinchImageView.getInnerMatrix(matrix)
            Log.d("seoungwoo -- ", "matrix = $matrix")
        }
        pinchImageView.setOnLongClickListener {
            (it as PinchImageView).run {
                val matrix = Matrix()
//                pinchImageView.getCurrentImageMatrix(matrix)
//                Log.d("seoungwoo -- ", "current matrix = $matrix")

                pinchImageView.getInnerMatrix(matrix)
//                pinchImageView.getOuterMatrix(matrix)
//                Log.d("seoungwoo -- ", "outer matrix = $matrix")
//                pinchImageView.getInnerMatrix(matrix)
//                Log.d("seoungwoo -- ", "inner matrix = $matrix")
                imageView2.visibility = View.VISIBLE
                imageView2.imageMatrix = matrix

            }
            true
        }

        imageView1.setOnLongClickListener {

            true
        }

        overlayView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            val intrinsicWidth = imageView1.drawable.intrinsicWidth.toFloat()
            val intrinsicHeight = imageView1.drawable.intrinsicHeight.toFloat()
            val src = RectF(0f, 0f, intrinsicWidth, intrinsicHeight)
            val dst = RectF(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat())
            val scale = Math.max(
                overlayView.width / intrinsicWidth,
                overlayView.height / intrinsicHeight
            )
            currentImageMatrix.postScale(scale, scale)
            currentImageMatrix.postTranslate(
                -Math.abs(intrinsicWidth * scale - overlayView.width) / 2f,
                dst.top
            )

//            currentImageMatrix.setRectToRect(src, dst, Matrix.ScaleToFit.CENTER)

            imageView1.imageMatrix = currentImageMatrix

        }

        imageView1.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            initializeCorner = RectUtils.getCornersFromRect(
                RectF(
                    left.toFloat(),
                    top.toFloat(),
                    right.toFloat(),
                    bottom.toFloat()
                )
            )
            currentImageMatrix.mapPoints(currentImageCorners, initializeCorner)
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
                            Log.d("seoungwoo -- ", "boundary")
                            return true
                        }
                    }
                    val temp = Matrix(currentImageMatrix)
                    temp.postScale(
                        detector!!.scaleFactor,
                        detector!!.scaleFactor,
                        touchCenterPoint.x,
                        touchCenterPoint.y
                    )
                    temp.mapPoints(currentImageCorners, initializeCorner)
                    if (!RectUtils.trapToRect(currentImageCorners).contains(rectF)) {
                        Log.d("seoungwoo -- ", "boundary")
                        currentImageMatrix.mapPoints(currentImageCorners, initializeCorner)
                        return true
                    }
                    currentImageMatrix.set(temp)
                    imageView1.imageMatrix = currentImageMatrix

                    return true
                }
            })
        val gestureDetector =
            GestureDetector(baseContext, object : GestureDetector.SimpleOnGestureListener() {
                override fun onDoubleTap(e: MotionEvent?): Boolean {

                    imageView2.visibility = View.VISIBLE
                    imageView2.imageMatrix = currentImageMatrix
                    return true
                }

            })

        imageView1.setOnTouchListener { v, event ->
            val asdf = FloatArray(9)

            if (gestureDetector.onTouchEvent(event)) {
                return@setOnTouchListener true
            }
            if (event.pointerCount > 1) {
                if (event.pointerCount > 1) {
                    val centerX = (event.getX(0) + event.getX(1)) / 2
                    val centerY = (event.getY(0) + event.getY(1)) / 2
                    touchCenterPoint.set(centerX, centerY)
                }
            }
            if (scaleGestureDetector.onTouchEvent(event))
                return@setOnTouchListener true
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {

                }
                else -> {
                }
            }
            true
        }

        imageView2.setOnLongClickListener {
            it.visibility = View.INVISIBLE
            true
        }
    }
}
