package com.jal.viewbinding

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> Fragment.viewBindingProvider(): ViewBindingProvider<T> {
    return ViewBindingProvider<T>().apply {
        viewLifecycleOwnerLiveData.observeForever {
            it?.lifecycle?.addObserver(this)
        }
    }
}
