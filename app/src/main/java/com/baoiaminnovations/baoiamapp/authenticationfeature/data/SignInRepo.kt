package com.baoiaminnovations.baoiamapp.authenticationfeature.data

import androidx.lifecycle.MutableLiveData
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class SignInRepo {
    val auth = Firebase.auth
    fun signInUser(emailOrPassword: String, password: String): MutableLiveData<String> {
        var result = MutableLiveData<String>()
        auth.signInWithEmailAndPassword(emailOrPassword, password).addOnCompleteListener {
            if (it.isSuccessful) {
                result.value = Constants.SUCCESS
            } else {
                result.value = Constants.FAILURE
            }
        }
        return result
    }
}