package com.baoiaminnovations.baoiamapp.common.presentation

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.authenticationfeature.data.PhoneSIgnInRepo
import com.baoiaminnovations.baoiamapp.authenticationfeature.data.PhoneSignUpRepo
import com.baoiaminnovations.baoiamapp.authenticationfeature.data.SignInRepo
import com.baoiaminnovations.baoiamapp.authenticationfeature.data.SignUpRepo
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.models.userModel
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.usecases.signInAuthentication
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.usecases.signUpAuthentication
import com.baoiaminnovations.baoiamapp.profileFeature.data.GetTheUserData
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val application: Application,
    private val signUpRepo: SignUpRepo,
    private val signInRepo: SignInRepo,
    private val getTheUserData: GetTheUserData,
    private val phoneSignUpRepo: PhoneSignUpRepo,
    private val phoneSIgnInRepo: PhoneSIgnInRepo
) : AndroidViewModel(application) {

    var result = MutableLiveData<String>()
    var resultSignIn = MutableLiveData<String>()
    var resultOfPhoneSignUp = MutableLiveData<String>()
    var resultOFPhoneSignUpWithCode = MutableLiveData<String>()
    var resultOfPhoneSignIn = MutableLiveData<String>()
    var resultOFPhoneSignInWithCode = MutableLiveData<String>()
    var userModelForUserName = mutableStateOf<userModel?>(userModel())
    var getDataOfUser = MutableLiveData<userModel>()

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

    fun getUserName(): String {
        val firestore = Firebase.firestore
        val result = firestore.collection("users").document(Firebase.auth.uid!!).get()
        result.addOnSuccessListener {
            userModelForUserName.value = it.toObject<userModel>()
        }
        return userModelForUserName.value?.name ?: ""
    }

    fun getDataOfUser() {
        getDataOfUser = getTheUserData.getData()
    }

    fun phoneSignUp(name: String, phoneNumber: String, activity: MainActivity) {
        phoneSignUpRepo.phoneSignUp(
            name,
            phoneNumber,
            activity,
            resultOfPhoneSignUp
        )
    }

    fun phoneSignUpWithCode(code: String, name: String, phoneNumber: String) {
        phoneSignUpRepo.enterCodeAndSignUp(
            code = code,
            name = name,
            phoneNumber = phoneNumber,
            returnValue = resultOFPhoneSignUpWithCode,
            application = application
        )
    }

    fun phoneSignIn(phoneNumber: String, activity: MainActivity) {
        phoneSIgnInRepo.phoneSignIn(
            phoneNumber,
            activity,
            resultOfPhoneSignIn
        )
    }

    fun phoneSignInWithCode(code: String) {
        phoneSIgnInRepo.enterCodeAndSignIn(
            code = code,
            returnValue = resultOFPhoneSignInWithCode,
            application = application
        )
    }
}