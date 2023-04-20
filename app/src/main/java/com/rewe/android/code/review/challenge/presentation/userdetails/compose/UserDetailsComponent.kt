package com.rewe.android.code.review.challenge.presentation.userdetails.compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rewe.android.code.review.challenge.R
import com.rewe.android.code.review.challenge.data.model.UserDetails
import com.rewe.android.code.review.challenge.presentation.users.compose.LoadingIndicator
import com.rewe.android.code.review.challenge.util.State

@Composable
fun UserDetailsRender(sta: State<UserDetails>) {
    when (sta) {
        is State.Error -> {}
        is State.Loading -> {
            LoadingIndicator()
        }
        is State.Success -> UserDetilsScreen(sta.data)
    }
}

@Composable
fun UserDetilsScreen(data: UserDetails) {
    Column(modifier = Modifier.fillMaxWidth().padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            data.avatarUrl,
            contentDescription = "",
            placeholder = painterResource(R.drawable.baseline_account_circle_24),
            modifier = Modifier.size(84.dp).clip(CircleShape),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(data.name!!)
        Spacer(modifier = Modifier.height(48.dp))
        Row(Modifier.fillMaxWidth()) {
            TableCell("Followers", 1f)
            TableCell(data.followers.toString(), 1f)
        }
        Row(Modifier.fillMaxWidth()) {
            TableCell("Following", 1f)
            TableCell(data.following.toString(), 1f)
        }

        Row(Modifier.fillMaxWidth()) {
            TableCell("Public Repos", 1f)
            TableCell(data.publicRepos.toString(), 1f)
        }

        Row(Modifier.fillMaxWidth()) {
            TableCell("Public Gists", 1f)
            TableCell(data.publicGists.toString(), 1f)
        }

    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )

}