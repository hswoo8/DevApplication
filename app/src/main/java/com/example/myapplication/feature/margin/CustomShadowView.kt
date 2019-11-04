package com.example.myapplication.feature.margin

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.jar.Attributes

class CustomShadowView : View {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributes: AttributeSet?) : super(context, attributes, 0)

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, paint)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.run {
            paint.style = Paint.Style.FILL
            paint.color = Color.BLUE
            paint.setShadowLayer(10f, 50f, 50f, Color.YELLOW)
            drawCircle(canvas.width / 2f, canvas.height / 2f, 50f, paint)
        }
    }
}