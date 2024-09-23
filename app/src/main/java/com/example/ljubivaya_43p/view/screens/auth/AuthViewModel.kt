package com.example.ljubivaya_43p.view.screens.auth

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.ljubivaya_43p.domain.Constant
import com.example.ljubivaya_43p.model.User
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    var userEmail by mutableStateOf("")
    var userPassword by mutableStateOf("")

    fun onSignInEmailPassword(navHostController: NavHostController) {
        viewModelScope.launch {
            try {
                Constant.supabase.auth.signInWith(Email) {
                    this.email = userEmail
                    this.password = userPassword
                }
                val user = Constant.supabase.auth.currentUserOrNull()
                if(user != null) {
                    val userId = user.id

                    val currentUser = Constant.supabase.from("users")
                        .select {
                            filter {
                                eq("id", userId)
                            }
                        }.decodeSingle<User>()

                    if (currentUser.role == "buyer") {
                        navHostController.navigate("main") {
                            popUpTo("auth") {
                                inclusive = true
                            }
                        }
                    }

                    if (currentUser.role == "admin") {
                        navHostController.navigate("admin") {
                            popUpTo("auth") {
                                inclusive = true
                            }
                        }
                    }

                }
                println(Constant.supabase.auth.currentUserOrNull()!!.id)
                Log.d("sign in", "Success")
                println("Success")
            } catch (e: Exception) {
                println("Error")
                println(e.message.toString())
            }
        }
    }

}