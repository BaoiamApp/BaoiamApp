package com.baoiaminnovations.baoiamapp.common.presentation


const val onBoardingGraph = "onboarding_graph"
const val authenticationGraph = "authentication_graph"
const val mainScreenGraph = "main_graph"

sealed class Screens(val route: String) {
    object OnBoardingScreen1 : Screens("onbroading_screen_1")
    object OnBoardingScreen2 : Screens("onbroading_screen_2")
    object OnBoardingScreen3 : Screens("onbroading_screen_3")
    object SignInScreen : Screens("sign_in_screen")
    object SignUpScreen : Screens("sign_up_screen")
    object ForgotPassword : Screens("forgot_password_screen")
    object OtpVerificationScreen : Screens("otp_verification_screen")
    object CreateNewPasswordScreen : Screens("create_new_password_screen")
    object PasswordUpdatedScreen : Screens("password_updated_screen")
    object AccountCreatedScreen : Screens("account_created_screen")
    object MainScreen : Screens("main_screen")
    object ExploreScreen : Screens("explore_screen")
    object MyCourseScreen : Screens("my_course_screen")
    object CareerScreen : Screens("career_screen")
    object ProfileScreen : Screens("profile_screen")
    object EditProfile : Screens("edit_profile_screen")
    object PopupWindow : Screens("popup_window_screen")
    object CapturedImage : Screens("captured_image_screen")
    object SettingsScreen : Screens("settings_screen")
    object OtpVerificationForNumberScreen :
        Screens("otp_verification_for_number_screen/?name={name}/?phoneNumber={phoneNumber}") {
        fun otpVerficationWIthNameAndPhoneNumber(name: String, phoneNumber: String): String {
            return "otp_verification_for_number_screen/?name=$name/?phoneNumber=$phoneNumber"
        }
    }
    object GeneralSetting : Screens("general_screen")
    object NotificationSetting : Screens("notification_settings")
    object AppLanguage : Screens("app_language")
    object Transactions : Screens("transactions")
    object PaymentOptions : Screens("payment_options")
    object HelpAndSupport : Screens("help_and_support")
    object ChatBot : Screens("chat_bot")
    object ContactUs : Screens("contact_us")
    object AboutUs : Screens("about_us")

}
