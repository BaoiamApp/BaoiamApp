package com.baoiaminnovations.baoiamapp.common.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.usecases.signUpAuthentication
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val application: Application
) : AndroidViewModel(application) {

    fun signUpAuthenticate(
        name: String,
        emailOrPhoneNumber: String,
        password: String,
        confirmPassword: String
    ): String {
        val result = signUpAuthentication(name, emailOrPhoneNumber, password, confirmPassword)
        return application.resources.getString(result)
    }
}