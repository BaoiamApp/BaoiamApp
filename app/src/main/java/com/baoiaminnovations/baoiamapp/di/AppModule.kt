package com.baoiaminnovations.baoiamapp.di

import com.baoiaminnovations.baoiamapp.authenticationfeature.data.PhoneSIgnInRepo
import com.baoiaminnovations.baoiamapp.authenticationfeature.data.PhoneSignUpRepo
import com.baoiaminnovations.baoiamapp.authenticationfeature.data.SignInRepo
import com.baoiaminnovations.baoiamapp.authenticationfeature.data.SignUpRepo
import com.baoiaminnovations.baoiamapp.profileFeature.data.GetTheUserData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun signUpRepo() = SignUpRepo()

    @Provides
    fun signInRepo() = SignInRepo()

    @Provides
    fun getTheUserData() = GetTheUserData()

    @Provides
    fun phoneSIgnUpRepo() = PhoneSignUpRepo()

    @Provides
    fun phoneSignInRepo() = PhoneSIgnInRepo()
}