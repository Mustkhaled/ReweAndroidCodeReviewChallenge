package com.rewe.android.code.review.challenge.presentation.users

import androidx.lifecycle.ViewModel
import com.rewe.android.code.review.challenge.data.model.Users
import com.rewe.android.code.review.challenge.domain.UsersUsecase
import com.rewe.android.code.review.challenge.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val useCase: UsersUsecase) : ViewModel() {
    val usersState = MutableStateFlow<State<List<Users>>>(State.Loading())

    init {
        GlobalScope.launch {
            getUsers()
        }
    }

    suspend fun getUsers() {
        useCase.getUsers().collectLatest {
            when (it) {
                is State.Error -> usersState.value = State.Error(Throwable("Unable to load data"))
                is State.Loading -> usersState.value = State.Loading()
                is State.Success -> usersState.value = State.Success(it.data)
            }
        }
    }
}