package com.rewe.android.code.review.challenge.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.rewe.android.code.review.challenge.R
import com.rewe.android.code.review.challenge.presentation.users.compose.UsersComponentRender
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UsersFragment : Fragment() {

    private val viewModel by viewModels<UsersViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            MaterialTheme {
                val state = viewModel.usersState.collectAsState().value
                UsersComponentRender(state, findNavController()) {
                    Snackbar.make(
                        rootView,
                        context.getString(R.string.error_message),
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}