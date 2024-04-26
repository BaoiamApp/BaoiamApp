package com.baoiaminnovations.baoiamapp.common.presentation

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baoiaminnovations.baoiamapp.authenticationfeature.data.SignInRepo
import com.baoiaminnovations.baoiamapp.authenticationfeature.data.SignUpRepo
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.usecases.signInAuthentication
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.usecases.signUpAuthentication
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val application: Application,
    private val signUpRepo: SignUpRepo,
    private val signInRepo: SignInRepo
) : AndroidViewModel(application) {

    var result = MutableLiveData<String>()
    var resultSignIn = MutableLiveData<String>()
    fun signUpAuthenticate(
        name: String,
        emailOrPhoneNumber: String,
        password: String,
        confirmPassword: String
    ): String {
        val result = signUpAuthentication(name, emailOrPhoneNumber, password, confirmPassword)
        return application.resources.getString(result)
    }

    fun signUp(name: String, emailOrPhoneNumber: String, password: String) {
        result = signUpRepo.signUpUser(name, emailOrPhoneNumber, password)
    }

    fun signInAuthenticate(name: String, password: String): String {
        val result = signInAuthentication(name, password)
        return application.resources.getString(result)

    }

    fun signIn(name: String, password: String) {
        resultSignIn = signInRepo.signInUser(name, password)
    }
}