package com.example.moviesmate.presentation.screens.containerFragment.profile

import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.moviesmate.databinding.FragmentProfileBinding
import com.example.moviesmate.presentation.base.BaseFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val viewModel by viewModel<ProfileViewModel>()

    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let { viewModel.onImageSelected(it) }
        }

    override fun viewCreated() {
        getUsername()
        getUserEmail()
        setListeners()
        setCollector()
    }

    private fun setListeners() = with(binding) {
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        updateUsernameButton.setOnClickListener {
            viewModel.updateUserName(usernameEditText.text.toString())
        }

        btnLogOut.setOnClickListener {
            viewModel.logOut()
            requireActivity().finish()
        }


        binding.btnUpdateImage.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }
    }


    private fun setCollector() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.username.collect {
                binding.userName.text = it
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userEmail.collect {
                binding.userEmail.text = it
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.selectedImageUri.collect { uri ->
                uri?.let {
                    binding.userImage.setImageURI(it)
                }
            }
        }
    }

    private fun getUsername() {
        viewModel.getUsername()
    }

    private fun getUserEmail() {
        viewModel.getUserEmail()
    }
}