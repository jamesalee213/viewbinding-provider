package com.jal.viewbinding

import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding

class ViewBindingProvider<T : ViewBinding> : DefaultLifecycleObserver {

    var binding: T? = null

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
