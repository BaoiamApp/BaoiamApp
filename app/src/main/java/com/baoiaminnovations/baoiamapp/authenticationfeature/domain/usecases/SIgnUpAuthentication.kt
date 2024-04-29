package com.baoiaminnovations.baoiamapp.authenticationfeature.domain.usecases

import android.util.Patterns
import androidx.core.text.isDigitsOnly
import com.baoiaminnovations.baoiamapp.R

fun signUpAuthentication(
    name: String,
    emailOrPhoneNumber: String,
    password: String,
    confirmPassword: String
): Int {
    if (name.isEmpty())
        return R.string.enterName


    if (emailOrPhoneNumber.isEmpty())
        return R.string.enterEmailOrPhoneNumber

    if (!emailOrPhoneNumber.isDigitsOnly()) {
        if (!Patterns.EMAIL_ADDRESS.matcher(emailOrPhoneNumber.trim()).matches())
            return R.string.emailValidation

        if (password.isEmpty())
            return R.string.enterPassword

        if (confirmPassword.isEmpty())
            return R.string.enterConfirmPassword

        if (password.trim() != confirmPassword.trim())
            return R.string.passwordValidation

    } else {
        if (emailOrPhoneNumber.length < 10)
            return R.string.phoneNumberValidation

        if (emailOrPhoneNumber.length > 10)
            return R.string.phoneNumberValidation
    }

    return R.string.validationAccepted
}