/*
 * @(#)GraphicUtils.java $version 2011. 4. 14.
 *
 * Copyright 2011 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.myapplication.util;

import android.content.Context;
import android.graphics.PointF;

import com.example.myapplication.BaseApplication;

/**
 * @author likebebop
 */
public class GraphicUtils {
    private static float MAX_BLUR_RADIUS_PX = 25.f;

    public static float pxToDp(int px) {
        final float scale = BaseApplication.context.getResources().getDisplayMetrics().density;
        return px / scale;
    }

    public static int dpToPx(float dp) {
        final float scale = BaseApplication.context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static float dpToPxFloat(float dp) {
        final float scale = BaseApplication.context.getResources().getDisplayMetrics().density;
        return dp * scale;
    }

    public static int getDimensionPixelSize(Context context, int id) {
        return context.getResources().getDimensionPixelSize(id);
    }

    static public float getDistance(PointF pt1, PointF pt2) {
        float x = pt1.x - pt2.x;
        float y = pt1.y - pt2.y;
        return (float) Math.sqrt(x * x + y * y);
    }

    static public float getDistance(float x1, float y1, float x2, float y2) {
        float x = x1 - x2;
        float y = y1 - y2;
        return (float) Math.sqrt(x * x + y * y);
    }

    static public float getDistance(float x1, float y1, float z1, float x2, float y2, float z2) {
        float x = x1 - x2;
        float y = y1 - y2;
        float z = z1 - z2;
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public static float getShadowRadiusPx(float dp) {
        // E/rsC++: RS CPP error: Blur radius out of 0-25 pixel bound
        return Math.max(0f, Math.min(MAX_BLUR_RADIUS_PX, GraphicUtils.dpToPxFloat(dp)));
    }
}
