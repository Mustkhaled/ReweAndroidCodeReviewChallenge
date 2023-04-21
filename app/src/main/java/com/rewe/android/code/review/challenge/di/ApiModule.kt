package com.rewe.android.code.review.challenge.di

import com.rewe.android.code.review.challenge.data.api.GithubUsersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

//TODO ApiModule could be installed in ViewModelComponent instead of SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    fun provideGithubUsersApi(retrofit: Retrofit): GithubUsersApi {
        return retrofit.create(GithubUsersApi::class.java)
    }
}