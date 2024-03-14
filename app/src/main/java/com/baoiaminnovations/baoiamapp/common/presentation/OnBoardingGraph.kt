package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnBoardingScreen1
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnBoardingScreen2
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnBoardingScreen4
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnboardingScreen3

fun NavGraphBuilder.onboardingGraph() {
    navigation(startDestination = Screens.OnBoardingScreen1.route, route = onBoardingGraph) {
        composable(route = Screens.OnBoardingScreen1.route) {
            OnBoardingScreen1()
        }
        composable(route = Screens.OnBoardingScreen2.route) {
            OnBoardingScreen2()
        }
        composable(route = Screens.OnBoardingScreen3.route) {
            OnboardingScreen3()
        }
        composable(route = Screens.OnBoardingScreen4.route) {
            OnBoardingScreen4()
        }
    }
}