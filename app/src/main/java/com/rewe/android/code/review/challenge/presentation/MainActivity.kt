package com.rewe.android.code.review.challenge.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.rewe.android.code.review.challenge.R
import com.rewe.android.code.review.challenge.databinding.ActivityMainBinding
import com.rewe.android.code.review.challenge.util.exhaustive
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbarTitle()
    }

    fun setupToolbarTitle() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        //TODO we can use setupWithNavActionBar
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.toolbar.title = when (destination.id) {
                R.id.usersFragment -> getString(R.string.user_label)
                R.id.userDetailsFragment -> getString(R.string.user_details_label)
                else -> {""}
            }.exhaustive
        }
    }
}