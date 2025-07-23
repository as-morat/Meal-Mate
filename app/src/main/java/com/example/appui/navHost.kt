package com.example.appui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appui.screens.FlashScreen
import com.example.appui.screens.HomeScreen
import com.example.appui.screens.WelcomeScreen

@Composable
fun NavHostApp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "flash"){

        composable("flash") { FlashScreen(navController) }
        composable("welcome") { WelcomeScreen(navController) }
        composable("home") { HomeScreen(navController) }

    }
}