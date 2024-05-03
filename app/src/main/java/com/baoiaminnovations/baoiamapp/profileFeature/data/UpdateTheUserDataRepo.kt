package com.baoiaminnovations.baoiamapp.profileFeature.data

import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.models.userModel
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.baoiaminnovations.baoiamapp.common.domain.FirebaseUserId
import com.google.firebase.Firebase
import com.google.firebase.app
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.storage

class UpdateTheUserDataRepo {
    val fireStore = Firebase.firestore
    val firebaseStorage = Firebase.storage
    var resultOfUpdatingProfile = MutableLiveData<String>()
    val resultOfUploadingProfile = MutableLiveData<String>()
    fun updateTheUserData(userModel: userModel): MutableLiveData<String> {
        var updateMap: HashMap<String, Any> = hashMapOf()
        updateMap["name"] = userModel.name
        updateMap["phoneNumber"] = userModel.phoneNumber
        updateMap["emailOrPhoneNumber"] = userModel.emailOrPhoneNumber
        fireStore.collection("users").document(FirebaseUserId.currentUser).update(updateMap)
            .addOnSuccessListener {
                resultOfUpdatingProfile.value = Constants.SUCCESS
            }.addOnFailureListener {
                resultOfUpdatingProfile.value = Constants.FAILURE
            }
        return resultOfUpdatingProfile
    }

    fun uploadTheProfilePicture(
        uri: Uri,
        extension: String,
        activity: MainActivity,
        showProgressBar: MutableState<Boolean>
    ): MutableLiveData<String> {
        val path = firebaseStorage.reference.child("IMAGE-${FirebaseUserId.currentUser}.$extension")
        path.putFile(uri).addOnSuccessListener {
            if (it.task.isSuccessful) {
                Toast.makeText(activity, "Picture uploaded successfully", Toast.LENGTH_SHORT).show()
                resultOfUploadingProfile.value = Constants.SUCCESS
                path.downloadUrl.addOnSuccessListener { picture ->
                    fireStore.collection("users").document(FirebaseUserId.currentUser)
                        .update("imageUrl", picture).addOnSuccessListener {
                            showProgressBar.value = false
                        }.addOnFailureListener{
                            showProgressBar.value = false
                        }
                }
            } else {
                resultOfUploadingProfile.value = Constants.FAILURE
                Toast.makeText(activity, "Failed to upload the picture", Toast.LENGTH_SHORT).show()
            }
        }
        return resultOfUploadingProfile
    }
}