package com.baoiaminnovations.baoiamapp.di

import com.baoiaminnovations.baoiamapp.authenticationfeature.data.SignUpRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun signUpRepo() = SignUpRepo()
}