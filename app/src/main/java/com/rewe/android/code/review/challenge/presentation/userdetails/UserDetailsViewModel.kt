package com.rewe.android.code.review.challenge.presentation.userdetails

import androidx.lifecycle.ViewModel
import com.rewe.android.code.review.challenge.data.model.UserDetails
import com.rewe.android.code.review.challenge.data.model.Users
import com.rewe.android.code.review.challenge.domain.UserDetailsUsecase
import com.rewe.android.code.review.challenge.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject
@HiltViewModel
class UserDetailsViewModel @Inject constructor(val useCase: UserDetailsUsecase): ViewModel() {

    val userDetailsState = MutableStateFlow<State<UserDetails>>(State.Loading())
    suspend fun getUserDetails(userId: String) {
        useCase.getUserDetails(userId).collectLatest {
            when(it) {
                is State.Error -> userDetailsState.value = State.Error(it.throwable)
                is State.Loading -> userDetailsState.value = State.Loading()
                is State.Success -> userDetailsState.value = State.Success(it.data)
            }
        }
    }
}