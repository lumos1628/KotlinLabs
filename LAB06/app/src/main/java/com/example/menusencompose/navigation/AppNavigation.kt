package com.example.menusencompose.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.menusencompose.ui.CustomScaffold
import com.example.menusencompose.ui.screens.HomeScreen
import com.example.menusencompose.ui.screens.ProfileScreen

enum class AppRoute { Home, Profile }

@Composable
fun MenusEnComposeApp() {
    val navController = rememberNavController()

    CustomScaffold(onProfileClick = { navController.navigate(AppRoute.Profile.name) }) { padding ->
        NavHost(
            navController = navController,
            startDestination = AppRoute.Home.name,
            modifier = Modifier.padding(padding)
        ) {
            composable(AppRoute.Home.name) { HomeScreen() }
            composable(AppRoute.Profile.name) { ProfileScreen() }
        }
    }
}
