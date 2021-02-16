package com.disizaniknem.ktornoteapp.ui.auth

import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.disizaniknem.ktornoteapp.R
import com.disizaniknem.ktornoteapp.other.Status
import com.disizaniknem.ktornoteapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_auth.*

@AndroidEntryPoint
class AuthFragment : BaseFragment(R.layout.fragment_auth) {

    private val viewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().requestedOrientation = SCREEN_ORIENTATION_PORTRAIT
        subscribeToObservers()

        btnRegister.setOnClickListener {
            val email = etRegisterEmail.text.toString()
            val password = etRegisterPassword.text.toString()
            val confirmedPassword = etRegisterPasswordConfirm.text.toString()
            viewModel.register(email, password, confirmedPassword)
        }
    }

    private fun subscribeToObservers() {
        viewModel.registerStatus.observe(viewLifecycleOwner, Observer { result ->
            result?.let {
                when (result.status) {
                    Status.SUCCESS -> {
                        registerProgressBar.visibility = View.GONE
                        showSnackbar(result.data ?: "Succesfully registered an account")
                    }
                    Status.ERROR -> {
                        registerProgressBar.visibility = View.GONE
                        showSnackbar(result.message ?: "An unknown error occured")
                    }
                    Status.LOADING -> {
                        registerProgressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

}