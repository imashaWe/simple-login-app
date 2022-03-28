package com.imasha.simpleloginapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.imasha.simpleloginapp.databinding.FragmentLoginBinding
import com.imasha.simpleloginapp.services.AuthService

class LoginFragment : Fragment() {
    private lateinit var _binding: FragmentLoginBinding
    private val binding get() = _binding

    private lateinit var authService: AuthService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authService = AuthService(activity?.applicationContext!!)
        _binding.buttonLogin.setOnClickListener { login() }
    }

    private fun login() {
        val userName = _binding.textUserName.text
        val email = _binding.textEmail.text
        authService.login(userName.toString(), email.toString())
        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
    }
}