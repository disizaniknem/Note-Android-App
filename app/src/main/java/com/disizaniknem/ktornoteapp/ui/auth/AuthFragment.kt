package com.disizaniknem.ktornoteapp.ui.auth

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.disizaniknem.ktornoteapp.R
import com.disizaniknem.ktornoteapp.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_auth.*

class AuthFragment  : BaseFragment(R.layout.fragment_auth) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogin.setOnClickListener {
            findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToNotesFragment())
        }
    }

}