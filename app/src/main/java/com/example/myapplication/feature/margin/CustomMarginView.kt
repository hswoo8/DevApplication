package com.example.myapplication.feature.margin

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.scale
import com.example.myapplication.util.DisplayUtils

class CustomMarginView : View {

    private var identity: Matrix = Matrix()
    private var paint = Paint()
    var bitmap: Bitmap? = null
        set(value) {
//            Log.d("seoungwoo -- ", "bitmap width(${bitmap!!.width}, height(${bitmap!!.height})")
//            field = Bitmap.createScaledBitmap(value, DisplayUtils.width, DisplayUtils.height, true)
            field = value
            Log.d("seoungwoo -- ", "bitmap width(${bitmap!!.width}, height(${bitmap!!.height})")
            invalidate()
        }


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    override fun onDraw(canvas: Canvas?) {
        if (bitmap == null || canvas == null) {
            return
        }

        val fl = 0.9f
        identity.postScale(fl, fl)
        identity.postTranslate((width - bitmap!!.width * 0.9f) / 2.0f, (height - bitmap!!.height * 0.9f) / 2.0f)

        canvas.drawBitmap(bitmap!!, identity, paint)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}