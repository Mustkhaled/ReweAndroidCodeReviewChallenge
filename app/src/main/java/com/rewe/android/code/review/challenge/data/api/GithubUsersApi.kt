package com.rewe.android.code.review.challenge.data.api

import com.rewe.android.code.review.challenge.data.model.UserDetails
import com.rewe.android.code.review.challenge.data.model.Users
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubUsersApi {
    @GET("users")
    suspend fun getUsers(): List<Users>

    @GET("users/{userId}")
    suspend fun getUserDetails(@Path("userId") userId: String): UserDetails
}