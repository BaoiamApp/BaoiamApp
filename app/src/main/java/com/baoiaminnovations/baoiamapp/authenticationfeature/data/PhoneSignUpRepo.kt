package com.baoiaminnovations.baoiamapp.authenticationfeature.data

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.models.userModel
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.baoiaminnovations.baoiamapp.common.presentation.AppViewModel
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.auth
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.firestore
import java.util.concurrent.TimeUnit

class PhoneSignUpRepo {
    val auth = Firebase.auth
    val firestore = Firebase.firestore
    var storedVerificationCode = ""
    fun phoneSignUp(
        name: String,
        phoneNumber: String,
        activity: MainActivity,
        returnValue: MutableLiveData<String>,
        viewModel: AppViewModel
    ) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber("+91$phoneNumber") // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(activity) // Activity (for callback binding)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    signInWithPhoneAuthCredential(credential, phoneNumber, name, returnValue)
                }

                override fun onVerificationFailed(exception: FirebaseException) {
                    if (exception is FirebaseAuthInvalidCredentialsException) {

                    }
                }

                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {
                    super.onCodeSent(verificationId, token)
                    storedVerificationCode = verificationId
                    viewModel.showVerificationAndOTPDialogBox.value = false
                    Toast.makeText(activity, "Receiving OTP", Toast.LENGTH_SHORT).show()
                }

            }) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun signInWithPhoneAuthCredential(
        credential: PhoneAuthCredential,
        phoneNumber: String,
        name: String,
        returnValue: MutableLiveData<String>
    ) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    returnValue.value = Constants.SUCCESS
                    val user = task.result?.user?.uid ?: ""
                    val userModel = userModel(name = name, phoneNumber = phoneNumber, userId = user)
                    firestore.collection("users").document(user).set(userModel, SetOptions.merge())
                } else {
                    returnValue.value = Constants.FAILURE
                    // Sign in failed, display a message and update the UI
                    // Update UI
                }
            }
    }

    fun enterCodeAndSignUp(
        code: String,
        phoneNumber: String,
        name: String,
        returnValue: MutableLiveData<String>,
        application: Application
    ) {
        println(code)
        try {
            val credential = PhoneAuthProvider.getCredential(storedVerificationCode, code)
            signInWithPhoneAuthCredential(credential, phoneNumber, name, returnValue)
        } catch (exception: IllegalArgumentException) {
            Toast.makeText(application, "Wrong code", Toast.LENGTH_SHORT).show()
        }

    }
}