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
import com.baoiaminnovations.baoiamapp.settingsfeature.AboutUs
import com.baoiaminnovations.baoiamapp.settingsfeature.AppLanguage
import com.baoiaminnovations.baoiamapp.settingsfeature.ChatBot
import com.baoiaminnovations.baoiamapp.settingsfeature.ContactUs
import com.baoiaminnovations.baoiamapp.settingsfeature.GeneralSetting
import com.baoiaminnovations.baoiamapp.settingsfeature.HelpAndSupport
import com.baoiaminnovations.baoiamapp.settingsfeature.NotificatiinSetting
import com.baoiaminnovations.baoiamapp.settingsfeature.PaymentOptions
import com.baoiaminnovations.baoiamapp.settingsfeature.SettingsScreen
import com.baoiaminnovations.baoiamapp.settingsfeature.Transactions

fun NavGraphBuilder.mainScreenGraph(
    navHostController: NavHostController,
    viewModel: AppViewModel,
    activity: MainActivity
) {
    navigation(startDestination = Screens.ExploreScreen.route, route = mainScreenGraph) {
        composable(Screens.ExploreScreen.route) {
            ExploreScreen(navHostController, viewModel,activity)
        }
        composable(Screens.MyCourseScreen.route) {
            MyCourse()
        }
        composable(Screens.CareerScreen.route) {
            CareerScreen()
        }
        composable(Screens.ProfileScreen.route) {
            ProfileScreen(navHostController,viewModel,activity)
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
            SettingsScreen(navHostController)
        }
        composable(Screens.GeneralSetting.route) {
            GeneralSetting(navHostController)
        }
        composable(Screens.NotificationSetting.route) {
            NotificatiinSetting()
        }
        composable(Screens.AppLanguage.route) {
            AppLanguage()
        }
        composable(Screens.Transactions.route) {
            Transactions()
        }
        composable(Screens.PaymentOptions.route) {
            PaymentOptions()
        }
        composable(Screens.HelpAndSupport.route) {
            HelpAndSupport(navHostController)
        }
        composable(Screens.ChatBot.route) {
            ChatBot()
        }
        composable(Screens.ContactUs.route) {
            ContactUs()
        }
        composable(Screens.AboutUs.route) {
            AboutUs()
        }
    }
}