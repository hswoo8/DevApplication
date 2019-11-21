package com.example.myapplication.feature.crop

import android.graphics.Matrix
import android.graphics.Rect
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapplication.PinchImageView
import com.example.myapplication.R

class CropActivity : AppCompatActivity() {

    @BindView(R.id.pinch_image_view)
    lateinit var pinchImageView: PinchImageView

    @BindView(R.id.image_view)
    lateinit var imageView: ImageView

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
                imageView.visibility = View.VISIBLE
                imageView.imageMatrix = matrix
            }
            true
        }



        imageView.setOnLongClickListener {
            it.visibility = View.INVISIBLE
            true
        }
    }
}
