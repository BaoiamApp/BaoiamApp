package com.baoiaminnovations.baoiamapp.common.presentation

import android.app.Application
import android.net.Uri
import androidx.compose.runtime.MutableState
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
import com.baoiaminnovations.baoiamapp.profileFeature.data.GetTheUserDataRepo
import com.baoiaminnovations.baoiamapp.profileFeature.data.UpdateTheUserDataRepo
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import dagger.hilt.android.lifecycle.HiltViewModel
import java.security.PrivateKey
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val application: Application,
    private val signUpRepo: SignUpRepo,
    private val signInRepo: SignInRepo,
    private val getTheUserDataRepo: GetTheUserDataRepo,
    private val phoneSignUpRepo: PhoneSignUpRepo,
    private val phoneSIgnInRepo: PhoneSIgnInRepo,
    private val updateTheUserDataRepo: UpdateTheUserDataRepo
) : AndroidViewModel(application) {

    var result = MutableLiveData<String>()
    var resultSignIn = MutableLiveData<String>()
    var resultOfPhoneSignUp = MutableLiveData<String>()
    var resultOFPhoneSignUpWithCode = MutableLiveData<String>()
    var resultOfPhoneSignIn = MutableLiveData<String>()
    var resultOFPhoneSignInWithCode = MutableLiveData<String>()
    var resultOfUpdatingUserData = MutableLiveData<String>("")
    var resultOfIUploadingProfilePicture = MutableLiveData<String>()
    var userModelForUserName = mutableStateOf<userModel?>(userModel())
    var getDataOfUser = MutableLiveData<userModel>()

    val showVerificationAndOTPDialogBox = mutableStateOf(true)
    val showVerifyingOTPDialogBox = mutableStateOf(false)

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
        getDataOfUser = getTheUserDataRepo.getData()
    }

    fun phoneSignUp(
        name: String,
        phoneNumber: String,
        activity: MainActivity,
        viewModel: AppViewModel
    ) {
        phoneSignUpRepo.phoneSignUp(
            name,
            phoneNumber,
            activity,
            resultOfPhoneSignUp,
            viewModel
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

    fun phoneSignIn(
        phoneNumber: String,
        activity: MainActivity,
        showDialogBox: MutableState<Boolean>
    ) {
        phoneSIgnInRepo.phoneSignIn(
            phoneNumber,
            activity,
            resultOfPhoneSignIn,
            showDialogBox
        )
    }

    fun phoneSignInWithCode(code: String) {
        phoneSIgnInRepo.enterCodeAndSignIn(
            code = code,
            returnValue = resultOFPhoneSignInWithCode,
            application = application
        )
    }

    fun updateTheUserData(userModel: userModel) {
        resultOfUpdatingUserData = updateTheUserDataRepo.updateTheUserData(userModel)
    }

    fun uploadingProfilePicture(uri: Uri, extension: String, activity: MainActivity,showProgressbar:MutableState<Boolean>) {
        resultOfIUploadingProfilePicture =
            updateTheUserDataRepo.uploadTheProfilePicture(uri, extension, activity,showProgressbar)
    }
}