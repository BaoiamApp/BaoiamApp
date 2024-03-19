package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.baoiaminnovations.baoiamapp.authenticationfeature.screens.SignInScreen
import com.baoiaminnovations.baoiamapp.authenticationfeature.screens.SignUpScreen
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnBoardingScreen1
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnBoardingScreen2
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnboardingScreen3

fun NavGraphBuilder.authenticationGraph(navHostController: NavHostController) {
    navigation(startDestination = Screens.SignInScreen.route, route = authenticationGraph) {
        composable(route = Screens.SignInScreen.route) {
            SignInScreen(navHostController)
        }
        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen(navHostController = navHostController)
        }
    }
}