package com.baoiaminnovations.baoiamapp.common.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.baoiaminnovations.baoiamapp.careerFeature.AllInternshipListScreen
import com.baoiaminnovations.baoiamapp.careerFeature.CareerScreen
import com.baoiaminnovations.baoiamapp.careerFeature.FilterContentScreen
import com.baoiaminnovations.baoiamapp.careerFeature.InternshipListBaoiamScreen
import com.baoiaminnovations.baoiamapp.careerFeature.PopularSearch
import com.baoiaminnovations.baoiamapp.careerFeature.ReportScreen
import com.baoiaminnovations.baoiamapp.careerFeature.ScholarshipScreen
import com.baoiaminnovations.baoiamapp.exploreFeature.screens.ExploreScreen
import com.baoiaminnovations.baoiamapp.myCourseFeature.MyCourse
import com.baoiaminnovations.baoiamapp.profileFeature.EditProfile
import com.baoiaminnovations.baoiamapp.profileFeature.ProfileScreen
import com.baoiaminnovations.baoiamapp.settingsfeature.SettingsScreen
fun NavGraphBuilder.mainScreenGraph(navHostController: NavHostController) {
    navigation(startDestination = Screens.ExploreScreen.route, route = mainScreenGraph) {
        composable(Screens.ExploreScreen.route) {
            ExploreScreen(navHostController)
        }
        composable(Screens.MyCourseScreen.route) {
            MyCourse()
        }
        composable(Screens.CareerScreen.route) {
           ReportScreen()
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

        composable(Screens.ScholarshipScreen.route) {
            ScholarshipScreen()
        }

    }
}