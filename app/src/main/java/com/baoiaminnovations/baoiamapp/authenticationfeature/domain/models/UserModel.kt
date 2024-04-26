package com.baoiaminnovations.baoiamapp.authenticationfeature.domain.models

data class userModel(
    val name: String,
    val emailOrPhoneNumber: String,
    val phoneNumber: String = "",
    val userId: String
)