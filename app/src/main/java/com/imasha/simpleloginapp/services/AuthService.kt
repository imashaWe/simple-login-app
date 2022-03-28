package com.imasha.simpleloginapp.services

import android.content.Context
import android.content.SharedPreferences

class AuthService(context: Context) {
    private lateinit var sharedPreference: SharedPreferences

    private val prefName = "AUTH_PREF"
    private val isLoggedInKey = "IS_LOGGED_IN"
    private val userNameKey = "userNameKey"
    private val emailKey = "emailKey"

    init {
        sharedPreference = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    val isLoggedIn get():Boolean = sharedPreference.getBoolean(isLoggedInKey, false)
    val userName get():String? = sharedPreference.getString(userNameKey, null)
    val email get():String? = sharedPreference.getString(emailKey, null)

    fun login(userName: String, email: String) {
        sharedPreference.edit().putString(userNameKey, userName)
        sharedPreference.edit().putString(emailKey, email)
    }


}