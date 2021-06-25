package com.pignasoft.dotasks.app.presentation

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.pignasoft.dotasks.R
import com.pignasoft.dotasks.base.delegate.viewBinding
import com.pignasoft.dotasks.base.extension.navigateSafe
import com.pignasoft.dotasks.base.navigation.NavManager
import com.pignasoft.dotasks.base.presentation.BaseActivity
import com.pignasoft.dotasks.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private val binding: ActivityMainBinding by viewBinding()
    private val navManager = NavManager()


    private val navController
        get() =
            (supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment).navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        initBottomNavigation()
        initNavManager()
    }

    private fun initNavManager() {
        navManager.setOnNavEventListener {
            supportFragmentManager.findFragmentById(R.id.fragment_container_view)?.childFragmentManager?.fragments?.first()
                ?.navigateSafe(it)
        }
    }

    private fun initBottomNavigation() {
        binding.bottomNav.setupWithNavController(navController)
        binding.bottomNav.setOnNavigationItemReselectedListener { }
    }


}
