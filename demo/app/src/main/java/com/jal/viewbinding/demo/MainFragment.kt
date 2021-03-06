package com.jal.viewbinding.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jal.viewbinding.checkViewBinding
import com.jal.viewbinding.demo.databinding.FragmentMainBinding
import com.jal.viewbinding.viewBindingProvider

class MainFragment : Fragment() {

    private val viewBindingProvider by viewBindingProvider<FragmentMainBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBindingProvider.initialize {
            FragmentMainBinding.inflate(layoutInflater, container, false).apply {
                textView.text = "What a wonderful world"
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setUpButton()
    }

    private fun setUpButton() {
        viewBindingProvider.binding?.apply {
            button.setOnClickListener {
                findNavController().navigate(MainFragmentDirections.toSecondFragment())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        checkViewBinding(viewBindingProvider.binding)
    }
}
