package com.jal.viewbinding.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jal.viewbinding.checkViewBinding
import com.jal.viewbinding.demo.databinding.FragmentSecondBinding
import com.jal.viewbinding.viewBindingProvider

class SecondFragment : Fragment() {

    private val viewBindingProvider by viewBindingProvider<FragmentSecondBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBindingProvider.initialize {
            FragmentSecondBinding.inflate(inflater, container, false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        checkViewBinding(viewBindingProvider.binding)
    }
}
