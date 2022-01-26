package com.jal.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jal.viewbinding.databinding.FragmentSecondBinding

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
