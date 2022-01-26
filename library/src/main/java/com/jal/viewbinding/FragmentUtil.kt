package com.jal.viewbinding

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBindingProvider(): ViewBindingProvider<T> {
    return ViewBindingProvider<T>().apply {
        viewLifecycleOwnerLiveData.observeForever {
            it?.lifecycle?.addObserver(this)
        }
    }
}

operator fun <T : ViewBinding> ViewBindingProvider<T>.getValue(
    thisRef: Any?,
    property: KProperty<*>
): ViewBindingProvider<T> = this
