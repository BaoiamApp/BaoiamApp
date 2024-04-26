package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.MainActivity

@Composable
fun NavHost(
    navHostController: NavHostController,
    viewModel: AppViewModel,
    activity: MainActivity
) {
    androidx.navigation.compose.NavHost(
        navController = navHostController,
        startDestination = authenticationGraph
    ) {
        onboardingGraph(navHostController)
        authenticationGraph(navHostController, viewModel, activity)
        mainScreenGraph(navHostController, viewModel, activity)
    }
}