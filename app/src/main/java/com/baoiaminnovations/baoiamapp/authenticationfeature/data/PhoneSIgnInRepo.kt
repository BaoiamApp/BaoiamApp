package com.baoiaminnovations.baoiamapp.authenticationfeature.data

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.models.userModel
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
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

class PhoneSIgnInRepo {
    val auth = Firebase.auth
    var storedVerificationCode = ""
    fun phoneSignIn(
        phoneNumber: String,
        activity: MainActivity,
        returnValue: MutableLiveData<String>,
        showDialogBox: MutableState<Boolean>
    ) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber("+91$phoneNumber") // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(activity) // Activity (for callback binding)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    signInWithPhoneAuthCredential(credential, returnValue)
                }

                override fun onVerificationFailed(exception: FirebaseException) {
                    if (exception is FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(
                            activity,
                            "This account does not exist. Please register first",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {
                    super.onCodeSent(verificationId, token)
                    showDialogBox.value = false
                    storedVerificationCode = verificationId
                    Toast.makeText(activity,"Receiving OTP",Toast.LENGTH_SHORT).show()
                }

            }) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun signInWithPhoneAuthCredential(
        credential: PhoneAuthCredential,
        returnValue: MutableLiveData<String>
    ) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    returnValue.value = Constants.SUCCESS

                } else {
                    returnValue.value = Constants.FAILURE
                    // Sign in failed, display a message and update the UI
                    // Update UI
                }
            }
    }

    fun enterCodeAndSignIn(
        code: String,
        returnValue: MutableLiveData<String>,
        application: Application
    ) {
        println(code)
        try {
            val credential = PhoneAuthProvider.getCredential(storedVerificationCode, code)
            signInWithPhoneAuthCredential(credential, returnValue)
        } catch (exception: IllegalArgumentException) {
            Toast.makeText(application, "Wrong code", Toast.LENGTH_SHORT).show()
        }

    }
}