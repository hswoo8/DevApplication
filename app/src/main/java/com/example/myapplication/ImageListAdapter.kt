package com.example.myapplication

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import java.io.File
import java.security.MessageDigest


class ImageListAdapter(val list: ArrayList<String>, val with: RequestManager) :
    RecyclerView.Adapter<ImageListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val parse = Uri.parse("file:///android_asset/image/${list[position]}")
        holder.bind(parse)
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var start: Long = 0L
        private val requestListener = object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                val now = System.currentTimeMillis()
                Log.d("seoungwoo -- ", "onLoadFailed elapsedTime(${now - start}")
                return true
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                val now = System.currentTimeMillis()
                Log.d("seoungwoo -- ", "onResourceReady elapsedTime(${now - start}")
                return true
            }
        }

        @BindView(R2.id.image)
        lateinit var thumbnail: ImageView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(path: Uri) {
            start = System.currentTimeMillis()

            val bitmapTransform =
                RequestOptions.bitmapTransform(MultiTransformation<Bitmap>(CenterCrop(), object : BitmapTransformation() {
                    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
                        Log.d("seoungwoo -- ", "updateDiskCacheKey")
                    }

                    override fun transform(
                        pool: BitmapPool,
                        toTransform: Bitmap,
                        outWidth: Int,
                        outHeight: Int
                    ): Bitmap {
                        val width = toTransform.width
                        val height = toTransform.height

                        val bitmap = pool.get(width, height, Bitmap.Config.ARGB_8888)
                        bitmap.setHasAlpha(true)
                        bitmap.density = toTransform.density //setCanvasBitmapDensity(toTransform, bitmap)

                        val canvas = Canvas(bitmap)
                        val paint = Paint()
                        paint.setAntiAlias(true)
                        paint.shader = BitmapShader(toTransform, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

                        canvas.drawRoundRect(RectF(100f, 100f, 100f, 100f), 25f, 25f, paint)
                        return bitmap
                    }
                })).skipMemoryCache(true)

            with
                .applyDefaultRequestOptions(bitmapTransform)
                .load(path)
                .error(R.drawable.error)
                .placeholder(R.drawable.error)
                .into(thumbnail)
        }
    }
}


