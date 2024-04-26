package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController

@Composable
fun NavHost(
    navHostController: NavHostController,
    viewModel: AppViewModel
) {
    androidx.navigation.compose.NavHost(
        navController = navHostController,
        startDestination = authenticationGraph
    ) {
        onboardingGraph(navHostController)
        authenticationGraph(navHostController, viewModel)
        mainScreenGraph(navHostController)
    }
}