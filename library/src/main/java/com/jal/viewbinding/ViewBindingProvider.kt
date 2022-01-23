package com.jal.viewbinding

import android.view.View
import androidx.viewbinding.ViewBinding

// TODO("add lifecycle")
class ViewBindingProvider<T : ViewBinding> {

    var binding: T? = null

    fun inflate(inflate: () -> T): View {
       return inflate().also {
           binding = it
       }.root
    }
}

// TODO: add Fragment extension for getting lifecycle owner
//       - get lifecycle owner
// might have to consider something for Activity
