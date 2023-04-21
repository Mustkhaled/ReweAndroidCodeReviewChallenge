package com.rewe.android.code.review.challenge.domain

import com.rewe.android.code.review.challenge.data.model.UserDetails
import com.rewe.android.code.review.challenge.data.repos.UserDetailsRepository
import com.rewe.android.code.review.challenge.data.repos.UserRepository
import com.rewe.android.code.review.challenge.presentation.userdetails.UserDetailsFragment
import com.rewe.android.code.review.challenge.util.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
//TODO userDetailsRepository can be private
class UserDetailsUsecase @Inject constructor(val userDetailsRepository: UserDetailsRepository){
    fun getUserDetails(userId: String): Flow<State<UserDetails>> = flow {
        emit(State.Loading())
        val response = userDetailsRepository.getUserDetails(userId)
        emit(State.Success(response))
    }.catch {
        emit(State.Error(it))
    }.flowOn(Dispatchers.Main)
}