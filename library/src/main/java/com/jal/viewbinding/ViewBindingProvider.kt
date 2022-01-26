package com.jal.viewbinding

import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KProperty

class ViewBindingProvider<T : ViewBinding> : DefaultLifecycleObserver {

    var binding: T? = null

    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): ViewBindingProvider<T> = this

    fun initialize(init: () -> T): View {
       return init().also {
           binding = it
       }.root
    }

    override fun onDestroy(owner: LifecycleOwner) {
        binding = null
        super.onDestroy(owner)
    }
}
