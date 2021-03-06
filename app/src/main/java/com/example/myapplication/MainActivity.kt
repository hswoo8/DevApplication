package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.myapplication.feature.binding.ExampleActivity
import com.example.myapplication.feature.crop.CropActivity
import com.example.myapplication.feature.margin.MarginActivity
import com.example.myapplication.feature.motion.MotionActivity
import com.example.myapplication.fragment.ContainerActivity

class MainActivity : AppCompatActivity()
//    , Communication
{

    @OnClick(R.id.margin_feature)
    fun onClickMarginFeature() {
        val intent = Intent(this, MarginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
    }

    @OnClick(R.id.motion_feature)
    fun onClickMotionFeature() {
        startActivity(Intent(this, MotionActivity::class.java))
    }

    @OnClick(R.id.crop_feature)
    fun onClickCrop_feature() {
        startActivity(Intent(this, CropActivity::class.java))
    }

    @OnClick(R.id.fragment_example)
    fun onClickFragmentExample() {
        startActivity(Intent(this, ContainerActivity::class.java))
    }

    @OnClick(R.id.binding_example)
    fun onClickBindingExample() {
        startActivity(Intent(this, ExampleActivity::class.java))
    }

    @BindView(R.id.checkbox)
    lateinit var checkBox: CheckBox

//    private lateinit var reverse: ConstraintSet
//
//    @BindView(R2.id.bottom_image_list)
//    lateinit var imageList: RecyclerView
//
//    @BindView(R2.id.image)
//    lateinit var pinchImageView: ImageView
//
//    val list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        onClickBindingExample()


//        onClickMarginFeature(findViewById(R.id.margin_feature))


//        setImageList()
//        Log.d("seoungwoo -- ", "start(${Date(System.currentTimeMillis())})")
//        Glide.with(this)
//        Log.d("seoungwoo -- ", "end(${Date(System.currentTimeMillis())})")
//        imageList.apply {
//            adapter = ImageListAdapter(list, Glide.with(this))
//            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
//        }
//
//        pinchImageView.setImageResource(R.drawable.error)


        val parent: Wrapper<Super> = Wrapper(Sub())
        val instance = getInstance()
    }

    fun getInstance(): Wrapper<Super> {
        return Wrapper<Sub>(Sub())
    }

    fun getInstance1(): ViewHolder<Wrapper<Super>> {
        val value = object : ViewHolder<Wrapper<Super>>(Wrapper(Sub())) {
            override fun bind(item: Wrapper<Super>) {

            }
        }

        return value
    }

    abstract class ViewHolder<T : Wrapper<Super>>(val item: T) {
        abstract fun bind(item: T)
    }

    open class Super {

    }

    class Sub : Super() {

    }

    abstract class Adapter<T : ViewHolder<Wrapper<Super>>>(item: T) {
        abstract fun bind(item: T)
    }

    class Wrapper<out T : Super>(val item: T)

    private fun setImageList() {
//        try {
//            val list1 = assets?.list("image")
//            list1?.asSequence()?.forEach {
//                list.add(it)
//            }
//            Log.d("seoungwoo -- ", "size(${list.size})")
//        } catch (e: Exception) {
//            Log.d("seoungwoo -- ", "assets open error")
//            e.printStackTrace()
//        }
    }

    override fun onResume() {
        super.onResume()

//        Glide.with(this)
//            .load("http://goo.gl/gEgYUd")
//            .into(pinchImageView)

//        val findViewById = findViewById<TextView>(R.id.text_view)
//        val startDelay = TransitionInflater.from(this)
//            .inflateTransition(R.transition.fade)
//            .addTarget(R.id.text_view)
//            .setDuration(1000L)
//            .setStartDelay(1000L)

//        val constraintLayout = findViewById<ConstraintLayout>(R.id.root_view)
//
//        val set2 = ConstraintSet()
//        set2.clone(constraintLayout)
//
//        reverse = ConstraintSet()
//        reverse.clone(constraintLayout)
//        reverse.connect(R.id.text_view, ConstraintSet.TOP, R.id.root_view, ConstraintSet.TOP)
//
//
//        constraintLayout.post { start() }
    }

//    fun start() {
//        val constraintLayout = findViewById<ConstraintLayout>(R.id.root_view)
//        val set = ConstraintSet()
//        set.clone(constraintLayout)
//        set.clear(R.id.text_view, ConstraintSet.TOP)
//
//        val autoTransition = ChangeBounds()
//        val fastOutLinearInInterpolator = FastOutLinearInInterpolator()
//        autoTransition.setInterpolator(object : TimeInterpolator {
//            override fun getInterpolation(input: Float): Float {
//                println("seoungwoo -- input($input)")
//                val interpolation = fastOutLinearInInterpolator.getInterpolation(input)
//                set.setAlpha(R.id.text_view, interpolation)
//                set.applyTo(constraintLayout)
//                println("seoungwoo -- interpolation($interpolation)")
//                return interpolation
//            }
//        })
//
//        autoTransition.duration = 4000
//        autoTransition.addListener(object : Transition.TransitionListener {
//            override fun onTransitionResume(transition: Transition?) {
//            }
//
//            override fun onTransitionPause(transition: Transition?) {
//            }
//
//            override fun onTransitionCancel(transition: Transition?) {
//            }
//
//            override fun onTransitionStart(transition: Transition?) {
//                Log.d("seoungwoo -- ", "on Start")
//            }
//
//            override fun onTransitionEnd(transition: Transition?) {
//                Log.d("seoungwoo -- ", "on End")
//                constraintLayout.post { reverse() }
//            }
//        })
//        TransitionManager.beginDelayedTransition(constraintLayout, autoTransition)
//        set.applyTo(constraintLayout)
//    }
//
//    fun reverse() {
//        val constraintLayout = findViewById<ConstraintLayout>(R.id.root_view)
//        val transition = ChangeBounds()
//        transition.setInterpolator {
//            reverse.setAlpha(R.id.text_view, 1.0f - it)
//            reverse.applyTo(constraintLayout)
//            FastOutLinearInInterpolator().getInterpolation(it)
//        }
//
//        transition.duration = 10000L
//        transition.addListener(object : Transition.TransitionListener {
//            override fun onTransitionEnd(transition: Transition?) {
//                start()
//            }
//
//            override fun onTransitionResume(transition: Transition?) {
//            }
//
//            override fun onTransitionPause(transition: Transition?) {
//            }
//
//            override fun onTransitionCancel(transition: Transition?) {
//            }
//
//            override fun onTransitionStart(transition: Transition?) {
//            }
//
//        })
//        TransitionManager.beginDelayedTransition(constraintLayout, transition)
//        reverse.applyTo(constraintLayout)
//    }
//
//    val oldestPerson = findOldestPerson(ArrayList())
//
//    fun findOldestPerson(list: List<Person>): Person {
//        list.maxBy { person -> person.age }
//        return Person("name", false, 0)
//    }
//
//
//    class Some(private val communication: Communication) {
//        init {
//            communication.get()
//
//            val provide = communication.provide()
//
//            communication.onReturnedProvider(provide)
//        }
//
//        private fun set() {
//            communication.get()
//        }
//    }
//
//    override fun get() {
//        println("ssong - get()")
//    }
//
//    override fun onReturnedProvider(): String {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun onReturnedProvider(string: String) {
//        println("return $string something to activity")
//    }
//
//    override fun provide(): String {
//        println("ssong - provide string activity to something")
//        return "ssong - Activity String"
//    }
}

//interface Communication {
//    fun get()
//
//    fun provide(): String
//    fun onReturnedProvider(string: String) //callback
//
//    fun onReturnedProvider(): String
//
//}
