package com.baoiaminnovations.baoiamapp.profileFeature.data

import androidx.lifecycle.MutableLiveData
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.models.userModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class GetTheUserDataRepo {
    fun getData(): MutableLiveData<userModel> {
        val getData = MutableLiveData<userModel>()
        val firestore = Firebase.firestore
        val result = firestore.collection("users").document(Firebase.auth.uid!!).get()
        result.addOnSuccessListener {
            getData.value = it.toObject<userModel>()
        }
        return getData
    }
}