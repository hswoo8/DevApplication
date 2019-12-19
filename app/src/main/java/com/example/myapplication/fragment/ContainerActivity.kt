package com.example.myapplication.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.myapplication.R

class ContainerActivity : AppCompatActivity(), FragmentLaunchInterface {
    var addBackStack = false
    @OnClick(R.id.add_button)
    fun onClickAddButton() {
        Log.d("seoungwoo -- ", "addBackStack = $addBackStack")
        onAdd(ChildFragment.newInstance(), addBackStack)
        addBackStack = !addBackStack
    }

    @OnClick(R.id.replace_button)
    fun onClickReplace() {
        onReplace(ChildFragment.newInstance(), true)
    }


    @OnClick(R.id.show_button)
    fun onClickShowButton() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_in_top, 0,
                0, 0)
            .show(supportFragmentManager.fragments.last())
            .commit()
    }

    @OnClick(R.id.hide_button)
    fun onCLickHideButton() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                0, R.anim.slide_out_top,
                0, 0
            )
            .hide(supportFragmentManager.fragments.last())
            .commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        ButterKnife.bind(this)
        onAdd(BasicFragment.newInstance(), false)
    }

    override fun onAdd(fragment: AbstractFragment, addBackStack: Boolean) {
        val findFragmentByTag = supportFragmentManager.findFragmentByTag(fragment.TAG)
        val beginTransaction = supportFragmentManager.beginTransaction()
        val customAnimations = beginTransaction
            .setCustomAnimations(
                R.anim.slide_in_bottom, R.anim.slide_out_top,
                R.anim.slide_in_left, R.anim.slide_out_bottom
            )
        if (findFragmentByTag != null) {
            beginTransaction
                .setCustomAnimations(
                    R.anim.slide_in_bottom, 0,
                    0, 0
                )
                .show(findFragmentByTag!!)
                .commit()
            return
        }
        beginTransaction
            .setCustomAnimations(
                R.anim.slide_in_bottom, R.anim.slide_out_top,
                R.anim.slide_in_left, R.anim.slide_out_bottom
            )
            .add(
                R.id.fragment_container, fragment,
                fragment.TAG
            )
            .addToBackStack(fragment.TAG)
            .commit()
    }

    override fun onReplace(fragment: AbstractFragment, backStack: Boolean) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_bottom,
                R.anim.fade_out,
                0,
                R.anim.slide_out_bottom
            )
            .replace(R.id.fragment_container, fragment, fragment.TAG)
            .addToBackStack(fragment.TAG)
            .commit()
    }

    override fun onBackPressed() {
//        if ((supportFragmentManager.fragments.size > 0)) {
//            val last = supportFragmentManager.fragments.last()
//            supportFragmentManager.beginTransaction()
//                .remove(last)
//                .commit()
//            return
//        }

        if ((supportFragmentManager.backStackEntryCount > 0)) {
            supportFragmentManager.popBackStack(
                supportFragmentManager.fragments.last().tag,
                POP_BACK_STACK_INCLUSIVE
            )
            return
        }

        super.onBackPressed()
    }
}

interface FragmentLaunchInterface {
    fun onAdd(fragment: AbstractFragment, addBackStack: Boolean)

    fun onReplace(fragment: AbstractFragment, backStack: Boolean)
}
