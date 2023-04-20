package com.rewe.android.code.review.challenge.presentation.users.compose

import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.rewe.android.code.review.challenge.R
import com.rewe.android.code.review.challenge.data.model.Users
import com.rewe.android.code.review.challenge.util.State

@Composable
fun UsersComponentRender(
    state: State<List<Users>>,
    navController: NavController,
    onError: () -> Unit
) {
    when (state) {
        is State.Error -> {
            onError()
        }
        is State.Loading -> {
            LoadingIndicator()
        }
        is State.Success -> UsersListScreen(state.data, navController)
    }
}

@Composable
fun UsersListScreen(data: List<Users>, navController: NavController) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        data.forEach {
            UserListItem(it, navController)
        }
    }
}

@Composable
fun UserListItem(users: Users, navController: NavController) {
    Row(modifier = Modifier.padding(16.dp).clickable {
        navController.navigate(
            R.id.action_usersFragment_to_userDetailsFragment,
            Bundle().apply {
                this.putString("userId", users.login)
            })
    }) {
        AsyncImage(
            model = users.avatarUrl,
            contentDescription = "",
            Modifier.clip(CircleShape).size(36.dp),
            placeholder = painterResource(R.drawable.baseline_account_circle_24)
        )

        Text(
            text = users.login.toString(),
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.weight(1.0f))
        Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "")
    }
}

@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(80.dp, 80.dp)
        )

    }
}