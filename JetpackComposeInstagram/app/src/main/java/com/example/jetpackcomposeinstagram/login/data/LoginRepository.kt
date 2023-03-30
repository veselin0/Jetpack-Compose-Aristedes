package com.cursokotlin.jetpackcomposeinstagram.login.data

import com.cursokotlin.jetpackcomposeinstagram.login.data.network.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(user:String, password:String):Boolean{
        return api.doLogin(user, password)
    }
}