package com.baoiaminnovations.baoiamapp.common.domain

import com.google.firebase.Firebase
import com.google.firebase.auth.auth

object FirebaseUserId {
    val currentUser = Firebase.auth.currentUser?.uid ?: ""
}