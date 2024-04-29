package com.baoiaminnovations.baoiamapp.authenticationfeature.data

import android.app.Application
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.MutableLiveData
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.models.userModel

import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.google.firebase.Firebase
import com.google.firebase.app
import com.google.firebase.auth.auth
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.firestore
import com.google.firebase.ktx.app
import javax.inject.Inject

class SignUpRepo {
    val auth = Firebase.auth
    val firestore = Firebase.firestore

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
                    val user = it.result.user?.uid ?: " "
                    val userModel =
                        userModel(name = name, emailOrPhoneNumber = emailOrNumber, userId = user)
                    firestore.collection("users").document(user)
                        .set(userModel, SetOptions.merge())

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