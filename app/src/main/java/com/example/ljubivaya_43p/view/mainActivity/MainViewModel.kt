package com.example.ljubivaya_43p.view.mainActivity

import android.provider.SyncStateContract
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ljubivaya_43p.R
import com.example.ljubivaya_43p.domain.Constant
import com.example.ljubivaya_43p.view.mainActivity.MainViewModel
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.providers.builtin.OTP
import kotlinx.coroutines.launch

class MainViewModel():ViewModel() {

    fun onSignInEmailCode(emailUser: String) {
        viewModelScope.launch {
            try {
                Constant.supabase.auth.signInWith(OTP) {
                    email = emailUser
                    createUser = false
                }

            } catch (e: Exception) {
                println(e.message.toString())

            }

        }
    }

    fun onSignInEmailPassword(emailUser: String, passwordUser: String) {
        viewModelScope.launch {
            try {
                val user = Constant.supabase.auth.signInWith(Email) {
                    email = emailUser
                    password = passwordUser
                }
                println(user.toString())
                println(Constant.supabase.auth.currentUserOrNull()!!.id)
                println("Success")
            } catch (e: Exception) {
                println("Error")
                println(e.message.toString())
            }
        }
    }
    fun onSignUpEmail(emailUser: String, passwordUser: String) {
        viewModelScope.launch {
            try{
                var  user =  Constant.supabase.auth.signUpWith(Email) {
                    email = emailUser
                    password = passwordUser
                }
                println(user.toString())
                println(Constant.supabase.auth.currentUserOrNull()!!.id)
                println("Success")
            }
            catch (e: Exception) {
                println("Error")
                println(e.message.toString())
            }

        }
    }
}