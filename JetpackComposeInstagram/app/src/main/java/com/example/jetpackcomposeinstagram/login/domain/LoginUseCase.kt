package com.example.jetpackcomposeinstagram.login.domain

<<<<<<< HEAD
=======
import com.example.jetpackcomposeinstagram.login.data.LoginRepository

>>>>>>> 6d52e721222e73451506f40995462444eeb1d166
class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user:String, password:String):Boolean{
        return repository.doLogin(user, password)
    }
}