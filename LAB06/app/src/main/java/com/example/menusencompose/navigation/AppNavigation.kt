package com.example.menusencompose.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.menusencompose.ui.CustomScaffold
import com.example.menusencompose.ui.screens.BuildScreen
import com.example.menusencompose.ui.screens.DeleteScreen
import com.example.menusencompose.ui.screens.FavoriteScreen
import com.example.menusencompose.ui.screens.HomeScreen
import com.example.menusencompose.ui.screens.MenuScreen
import com.example.menusencompose.ui.screens.ProfileScreen

@Composable
fun MenusEnComposeApp() {
    val navController = rememberNavController()
    var clickCount by rememberSaveable { mutableIntStateOf(0) }

    CustomScaffold(
        onProfileClick = { navController.navigate(AppRoute.Profile.name) },
        onNavigate = { route -> navController.navigate(route.name) },
        onFabClick = { clickCount++ }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = AppRoute.Home.name,
            modifier = Modifier.padding(padding)
        ) {
            composable(AppRoute.Home.name) { HomeScreen(clickCount = clickCount) }
            composable(AppRoute.Profile.name) { ProfileScreen() }
            composable(AppRoute.Build.name) { BuildScreen() }
            composable(AppRoute.Menu.name) { MenuScreen() }
            composable(AppRoute.Favorite.name) { FavoriteScreen() }
            composable(AppRoute.Delete.name) { DeleteScreen() }
        }
    }
}
