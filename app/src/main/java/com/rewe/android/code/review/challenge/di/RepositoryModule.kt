package com.rewe.android.code.review.challenge.di

import com.rewe.android.code.review.challenge.data.api.GithubUsersApi
import com.rewe.android.code.review.challenge.data.repos.UserDetailsRepository
import com.rewe.android.code.review.challenge.data.repos.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
//TODO ApiModule could be installed in ViewModelComponent instead of SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideUsersRepository(
        githubUsersApi: GithubUsersApi
    ): UserRepository = UserRepository(githubUsersApi)

    @Provides
    fun providesUserDetailsRepository(githubUsersApi: GithubUsersApi) =
        UserDetailsRepository(githubUsersApi)
}