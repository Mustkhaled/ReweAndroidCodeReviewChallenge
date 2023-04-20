package com.rewe.android.code.review.challenge.domain

import com.rewe.android.code.review.challenge.data.model.Users
import com.rewe.android.code.review.challenge.data.repos.UserRepository
import com.rewe.android.code.review.challenge.util.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class UsersUsecase @Inject constructor(private val userRepository: UserRepository){
    fun getUsers(): Flow<State<List<Users>>>  = flow {
        emit(State.Loading())
        val response = userRepository.getUsers()
        emit(State.Success(response))
    }.catch {
        emit(State.Error(it))
    }.flowOn(Dispatchers.IO)
}