package com.rokiba.lostandfound.ui.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rokiba.lostandfound.R
import com.rokiba.lostandfound.databinding.ActivityMainBinding
import com.rokiba.lostandfound.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(MainViewModel::class.java) {

    override fun bindViewModel() {
        dataBinding.viewModel = viewModel
    }

    override fun getLayout() = R.layout.activity_main

    override fun init(savedInstanceState: Bundle?) {
        val navView: BottomNavigationView = dataBinding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(object : NavController.OnDestinationChangedListener{
            /**
             * Callback for when the [currentDestination] or its arguments change.
             * This navigation may be to a destination that has not been seen before, or one that
             * was previously on the back stack. This method is called after navigation is complete,
             * but associated transitions may still be playing.
             *
             * @param controller the controller that navigated
             * @param destination the new destination
             * @param arguments the arguments passed to the destination
             */
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {
                if (destination.id == R.id.navHome){
                    dataBinding.txtTitle.setText("Home")
                } else if (destination.id == R.id.navFound){
                    dataBinding.txtTitle.setText("Found Items")
                } else if (destination.id == R.id.navLost){
                    dataBinding.txtTitle.setText("Lost Items")
                } else if (destination.id == R.id.navProfile){
                    dataBinding.txtTitle.setText("Profile")
                }
            }

        })
    }
}