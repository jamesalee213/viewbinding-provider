package com.jal.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jal.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rooView = ViewBindingProvider<ActivityMainBinding>().initialize {
            ActivityMainBinding.inflate(layoutInflater)
        }
        setContentView(rooView)
    }
}
