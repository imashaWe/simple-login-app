package com.imasha.simpleloginapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.imasha.simpleloginapp.databinding.FragmentMainBinding
import com.imasha.simpleloginapp.services.AuthService

class MainFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding
    private val binding get() = _binding
    private lateinit var authService: AuthService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authService = AuthService(activity?.applicationContext!!)
        if (authService.isLoggedIn) navigateToHome() else navigateToLogin()
    }

    private fun navigateToLogin() {
        findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
    }

    private fun navigateToHome() {
        findNavController().navigate(R.id.action_mainFragment_to_homeFragment)
    }
}