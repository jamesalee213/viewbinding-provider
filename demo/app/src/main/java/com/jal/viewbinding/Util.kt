package com.jal.viewbinding

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> Fragment.checkViewBinding(viewBinding: T?) {
    val fragmentName = this::class.simpleName.toString()

    println("### Example from $fragmentName: ViewBinding is $viewBinding")

    Toast.makeText(
        requireContext(),
        "$fragmentName ViewBinding is: $viewBinding",
        Toast.LENGTH_SHORT
    ).show()
}
