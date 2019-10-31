package com.example.myapplication.feature.margin

import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.Size
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.myapplication.R
import com.example.myapplication.util.DisplayUtils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import java.io.InputStream

class MarginActivity : AppCompatActivity() {

    @BindView(R.id.margin_image_view)
    lateinit var marginImageView: CustomMarginView

    val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_margin)
        ButterKnife.bind(this)

        findViewById<View>(R.id.root_view)
            .addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
                DisplayUtils.width = v.width
                DisplayUtils.height = v.height
            }

//        applicationContext.assets.list()

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        val open = assets.open("image/baby-20339.jpg")
        add(loadBitmap(open))
    }

    private fun loadBitmap(open: InputStream): Disposable {
        return Observable.fromFuture(
            Glide.with(marginImageView)
                .load(open.readBytes())
                .fitCenter()
                .override(DisplayUtils.width, DisplayUtils.height)
                .submit()
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    (it as? BitmapDrawable)?.run {
                        marginImageView.bitmap = this.bitmap
                    }

                }, { t -> t.printStackTrace() })
    }

    private fun add(d: Disposable) {
        disposables.add(d)
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()

    }
}
