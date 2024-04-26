package com.baoiaminnovations.baoiamapp.authenticationfeature.data

import android.app.Application
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.MutableLiveData
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import javax.inject.Inject

class SignUpRepo {
    val auth = Firebase.auth

    fun signUpUser(
        name: String,
        emailOrNumber: String,
        password: String
    ): MutableLiveData<String> {
        var returnValue = MutableLiveData<String>()
        if (!emailOrNumber.isDigitsOnly()) {
            val result = auth.createUserWithEmailAndPassword(emailOrNumber, password)
            result.addOnCompleteListener() {
                if (it.isSuccessful) {
                    returnValue.value = Constants.SUCCESS
                } else {
                    returnValue.value = Constants.FAILURE
                }
            }
            return returnValue
        } else {
            return MutableLiveData()
        }
    }
}