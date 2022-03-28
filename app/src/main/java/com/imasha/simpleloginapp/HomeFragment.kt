package com.imasha.simpleloginapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.imasha.simpleloginapp.databinding.FragmentHomeBinding
import com.imasha.simpleloginapp.services.AuthService

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding

    private lateinit var authService: AuthService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authService = AuthService(activity?.applicationContext!!)
        binding.textUserName.text = "User Name: ${authService.userName}"
        binding.textEmail.text = "Email: ${authService.email}"

        _binding.buttonLogout.setOnClickListener { logout() }
    }

    private fun logout() {
        authService.logout()
        findNavController().navigate(R.id.action_homeFragment_to_mainFragment)
    }
}