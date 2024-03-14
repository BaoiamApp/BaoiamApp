package com.baoiaminnovations.baoiamapp.common.presentation


const val onBoardingGraph = "onboarding_graph"
sealed class Screens(val route: String) {
    object OnBoardingScreen1:Screens("onbroading_screen_1")
    object OnBoardingScreen2:Screens("onbroading_screen_1")
    object OnBoardingScreen3:Screens("onbroading_screen_1")
    object OnBoardingScreen4:Screens("onbroading_screen_1")
}
