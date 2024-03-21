package com.baoiaminnovations.baoiamapp.common.presentation


const val onBoardingGraph = "onboarding_graph"
const val authenticationGraph = "authentication_graph"

sealed class Screens(val route: String) {
    object OnBoardingScreen1 : Screens("onbroading_screen_1")
    object OnBoardingScreen2 : Screens("onbroading_screen_2")
    object OnBoardingScreen3 : Screens("onbroading_screen_3")
    object SignInScreen : Screens("sign_in_screen")
    object SignUpScreen : Screens("sign_up_screen")
    object ForgotPassword : Screens("forgot_password_screen")
    object OtpVerificationScreen : Screens("otp_verfication_screen")
}
