package com.rewe.android.code.review.challenge.presentation.userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.navArgs
import com.rewe.android.code.review.challenge.presentation.userdetails.compose.UserDetailsRender
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async

@AndroidEntryPoint
class UserDetailsFragment : Fragment() {

    private val viewModel by viewModels<UserDetailsViewModel>()
    //TODO "userId" is not added to companion object
    private val userId by lazy {
        arguments?.getString("userId")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            MaterialTheme {
                val state = viewModel.userDetailsState.collectAsState().value
                UserDetailsRender(state)
            }
        }
    }

    //TODO Async shouldn't be used if no deferred result expected
    //TODO the network call is called at onResume() callback, it means if user press home on his device and return baco the app. It will reload.
    override fun onResume() {
        super.onResume()
        lifecycle.coroutineScope.async {
            viewModel.getUserDetails(userId.toString())
        }

    }
}