package com.example.ljubivaya_43p.domain

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ljubivaya_43p.view.screens.adminscreen.AdminScreen
import com.example.ljubivaya_43p.view.screens.auth.Auth
import com.example.ljubivaya_43p.view.screens.mainscreen.MainScreen

@Composable
fun Navigation() {
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = "auth") {

        composable("auth") {
            Auth(navHostController)
        }

        composable("main") {
            MainScreen(navHostController)
        }

        composable("admin") {
            AdminScreen(navHostController)
        }

    }
}

