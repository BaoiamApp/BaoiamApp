package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.activity
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.careerFeature.CareerScreen
import com.baoiaminnovations.baoiamapp.exploreFeature.screens.ExploreScreen
import com.baoiaminnovations.baoiamapp.myCourseFeature.MyCourse

import com.baoiaminnovations.baoiamapp.profileFeature.presentation.EditProfile
import com.baoiaminnovations.baoiamapp.profileFeature.presentation.ProfileScreen
import com.baoiaminnovations.baoiamapp.settingsfeature.SettingsScreen

fun NavGraphBuilder.mainScreenGraph(
    navHostController: NavHostController,
    viewModel: AppViewModel,
    activity: MainActivity
) {
    navigation(startDestination = Screens.ExploreScreen.route, route = mainScreenGraph) {
        composable(Screens.ExploreScreen.route) {
            ExploreScreen(navHostController, viewModel)
        }
        composable(Screens.MyCourseScreen.route) {
            MyCourse()
        }
        composable(Screens.CareerScreen.route) {
            CareerScreen()
        }
        composable(Screens.ProfileScreen.route) {
            ProfileScreen(navHostController)
        }
        composable(Screens.EditProfile.route) {
            EditProfile(navHostController, viewModel, activity)
        }

        /*composable(Screens.PopupWindow.route) {
            PopUpWindow(navHostController)
        }*/
        /*composable(Screens.CapturedImage.route) {
            CapturedImage()
        }*/
        composable(Screens.SettingsScreen.route) {
            SettingsScreen()
        }
    }
}