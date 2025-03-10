package com.example.moviesmate.presentation.screens.passwordRecover.verifyEmail

import androidx.navigation.fragment.findNavController
import com.example.moviesmate.databinding.FragmentVerifyEmailBinding
import com.example.moviesmate.core.base.BaseFragment

class VerifyEmailFragment :
    BaseFragment<FragmentVerifyEmailBinding>(FragmentVerifyEmailBinding::inflate) {

    override fun viewCreated() {
        setListeners()
    }

    private fun setListeners() = with(binding) {
        btnLogInPage.setOnClickListener {
            goToLogInFragment()
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun goToLogInFragment(){
        findNavController().navigate(VerifyEmailFragmentDirections.actionVerifyEmailFragmentToLoginFragment())
    }

}