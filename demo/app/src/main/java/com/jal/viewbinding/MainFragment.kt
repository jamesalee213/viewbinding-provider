package com.jal.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jal.viewbinding.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val viewBindingProvider = ViewBindingProvider<FragmentMainBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBindingProvider.inflate {
            FragmentMainBinding.inflate(layoutInflater, container, false)
        }
    }
}
