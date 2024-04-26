package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.screens.AccountCreated
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.screens.CreateNewPassword
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.screens.ForgotPassword
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.screens.OtpVerification
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.screens.PasswordUpdated
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.screens.SignInScreen
import com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.screens.SignUpScreen
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnBoardingScreen1
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnBoardingScreen2
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnboardingScreen3

fun NavGraphBuilder.authenticationGraph(
    navHostController: NavHostController,
    viewModel: AppViewModel,
    activity: MainActivity
) {
    navigation(startDestination = Screens.SignInScreen.route, route = authenticationGraph) {
        composable(route = Screens.SignInScreen.route) {
            SignInScreen(navHostController)
        }
        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen(navHostController = navHostController, viewModel,activity)
        }
        composable(route = Screens.ForgotPassword.route) {
            ForgotPassword(navHostController)
        }
        composable(route = Screens.OtpVerificationScreen.route) {
            OtpVerification(navHostController)
        }
        composable(Screens.CreateNewPasswordScreen.route) {
            CreateNewPassword(navHostController)
        }
        composable(Screens.PasswordUpdatedScreen.route) {
            PasswordUpdated(navHostController)
        }
        composable(Screens.AccountCreatedScreen.route) {
            AccountCreated(navHostController = navHostController)
        }
    }
}