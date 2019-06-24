package br.com.ruyano.onboardingexample.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.initToolbar(titleResId: Int, backEnabled: Boolean) {
    (activity as AppCompatActivity).supportActionBar?.run {
        setTitle(titleResId)
        setDisplayHomeAsUpEnabled(backEnabled)
    }
}