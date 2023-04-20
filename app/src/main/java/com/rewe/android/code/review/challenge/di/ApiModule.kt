package com.rewe.android.code.review.challenge.di

import com.rewe.android.code.review.challenge.data.api.GithubUsersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    fun provideGithubUsersApi(retrofit: Retrofit): GithubUsersApi {
        return retrofit.create(GithubUsersApi::class.java)
    }
}