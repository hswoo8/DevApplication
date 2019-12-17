package com.example.myapplication.fragment

import androidx.fragment.app.Fragment

abstract class AbstractFragment(id: Int) : Fragment(id), OnBackPressed {
    open var TAG: String = "AbstractFragment"
}

interface OnBackPressed {

}