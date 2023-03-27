package com.example.jetpackcomposeinstagram.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    fun onLoginChanged(email: String) {
        _email.value = email
    }

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
}