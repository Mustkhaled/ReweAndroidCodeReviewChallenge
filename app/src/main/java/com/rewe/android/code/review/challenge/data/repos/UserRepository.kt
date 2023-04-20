package com.rewe.android.code.review.challenge.data.repos

import com.rewe.android.code.review.challenge.data.api.GithubUsersApi
import javax.inject.Inject

class UserRepository @Inject constructor(private val usersApi: GithubUsersApi) {
    suspend fun getUsers() = usersApi.getUsers()
}