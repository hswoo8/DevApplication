package com.example.myapplication.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        ButterKnife.bind(this)
        onAdd(BasicFragment.newInstance(), false)
    }

    override fun onAdd(fragment: AbstractFragment, addBackStack: Boolean) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment, fragment.TAG)
            .commit()
    }

    override fun onReplace(fragment: AbstractFragment, backStack: Boolean) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment, fragment.TAG)
            .commit()
    }

    override fun onBackPressed() {
        if ((supportFragmentManager.fragments.size > 0)) {
            val last = supportFragmentManager.fragments.last()
            supportFragmentManager.beginTransaction()
                .remove(last)
                .commit()
            return
        }

        super.onBackPressed()
    }
}

interface FragmentLaunchInterface {
    fun onAdd(fragment: AbstractFragment, addBackStack: Boolean)

    fun onReplace(fragment: AbstractFragment, backStack: Boolean)
}
