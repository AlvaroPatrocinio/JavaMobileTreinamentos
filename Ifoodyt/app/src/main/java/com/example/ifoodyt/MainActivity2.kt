package com.example.ifoodyt

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.ifoodyt.databinding.ActivityMainBinding

/**
 * Loads [MainFragment].
 */

class MainActivity2 : FragmentActivity() {

    private val binding by lazy {
    ActivityMainBinding.inflate( layoutInflater )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )
    }
}