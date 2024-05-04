package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants

@Composable
fun NavHost(
    navHostController: NavHostController,
    viewModel: AppViewModel,
    activity: MainActivity,
    result: String
) {
    androidx.navigation.compose.NavHost(
        navController = navHostController,
        startDestination = if (result == Constants.MAIN_SCREEN_VALUE) mainScreenGraph else if (result == Constants.AUTH_SCREEN_VALUE) authenticationGraph else onBoardingGraph
    ) {
        onboardingGraph(navHostController)
        authenticationGraph(navHostController, viewModel, activity)
        mainScreenGraph(navHostController, viewModel, activity)
    }
}