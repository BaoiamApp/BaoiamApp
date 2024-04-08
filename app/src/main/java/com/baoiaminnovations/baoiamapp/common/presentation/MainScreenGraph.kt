package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.baoiaminnovations.baoiamapp.careerFeature.CareerScreen
import com.baoiaminnovations.baoiamapp.exploreFeature.ExploreScreen
import com.baoiaminnovations.baoiamapp.myCourseFeature.MyCourse
import com.baoiaminnovations.baoiamapp.profileFeature.EditProfile
import com.baoiaminnovations.baoiamapp.profileFeature.ProfileScreen
import com.baoiaminnovations.baoiamapp.settingsfeature.SettingsScreen

fun NavGraphBuilder.mainScreenGraph(navHostController: NavHostController) {
    navigation(startDestination = Screens.ExploreScreen.route, route = mainScreenGraph) {
        composable(Screens.ExploreScreen.route) {
            ExploreScreen()
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
            EditProfile()
        }
        composable(Screens.SettingsScreen.route) {
            SettingsScreen()
        }
    }
}