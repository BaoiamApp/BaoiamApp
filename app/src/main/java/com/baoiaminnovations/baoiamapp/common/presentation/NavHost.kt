package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController

@Composable
fun NavHost(
    navHostController: NavHostController
) {
    androidx.navigation.compose.NavHost(
        navController = navHostController,
        startDestination = mainScreenGraph
    ) {
        onboardingGraph(navHostController)
        authenticationGraph(navHostController)
        mainScreenGraph(navHostController)
    }
}