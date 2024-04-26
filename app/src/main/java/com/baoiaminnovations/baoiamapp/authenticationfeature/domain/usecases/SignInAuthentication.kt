package com.baoiaminnovations.baoiamapp.authenticationfeature.domain.usecases

import com.baoiaminnovations.baoiamapp.R

fun signInAuthentication(name: String, password: String): Int {
    if (name.isEmpty())
        return R.string.enterEmailOrPhoneNumber

    if (password.isEmpty())
        return R.string.enterPassword

    return R.string.validationAccepted
}