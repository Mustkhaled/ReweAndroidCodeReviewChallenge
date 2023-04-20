package com.rewe.android.code.review.challenge.data.repos

import com.rewe.android.code.review.challenge.data.api.GithubUsersApi
import javax.inject.Inject

class UserDetailsRepository @Inject constructor(private val usersApi: GithubUsersApi) {
    suspend fun getUserDetails(userId: String) = usersApi.getUserDetails(userId)
}