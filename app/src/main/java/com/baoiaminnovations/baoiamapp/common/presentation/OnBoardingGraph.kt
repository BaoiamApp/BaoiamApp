package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnBoardingScreen1
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnBoardingScreen2
import com.baoiaminnovations.baoiamapp.onboardingfeature.screens.OnboardingScreen3

fun NavGraphBuilder.onboardingGraph(navHostController: NavHostController) {
    navigation(startDestination = Screens.OnBoardingScreen1.route, route = onBoardingGraph) {
        composable(route = Screens.OnBoardingScreen1.route,
            enterTransition = {
                return@composable slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = { return@composable slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left) },
            popEnterTransition = {
                return@composable slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            },
            popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left
                )
            }) {
            OnBoardingScreen1(navHostController)
        }
        composable(route = Screens.OnBoardingScreen2.route,
            enterTransition = {
                return@composable slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = { return@composable slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left) },
            popEnterTransition = {
                return@composable slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            },
            popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left
                )
            }) {
            OnBoardingScreen2(navHostController)
        }
        composable(route = Screens.OnBoardingScreen3.route, enterTransition = {
            return@composable slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
        },
            exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right
                )
            },
            popEnterTransition = {
                return@composable slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            },
            popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left
                )
            }) {
            OnboardingScreen3(navHostController)
        }
    }
}