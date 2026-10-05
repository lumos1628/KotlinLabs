package com.example.menusencompose.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.menusencompose.navigation.AppRoute

@Composable
fun CustomScaffold(
    onProfileClick: () -> Unit,
    onNavigate: (AppRoute) -> Unit,
    onFabClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { CustomTopBar(onProfileClick = onProfileClick) },
        bottomBar = { CustomBottomBar(onNavigate = onNavigate) },
        floatingActionButton = { CustomFAB(onClick = onFabClick) },
        content = content
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(onProfileClick: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Rounded.Search, contentDescription = null)
            }
            IconButton(onClick = onProfileClick) {
                Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "Perfil")
            }
        }
    )
}

@Composable
fun CustomBottomBar(onNavigate: (AppRoute) -> Unit) {
    BottomAppBar {
        IconButton(onClick = { onNavigate(AppRoute.Build) }, modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Filled.Build, contentDescription = "Build")
        }
        IconButton(onClick = { onNavigate(AppRoute.Menu) }, modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
        }
        IconButton(onClick = { onNavigate(AppRoute.Favorite) }, modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
        }
        IconButton(onClick = { onNavigate(AppRoute.Delete) }, modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete")
        }
    }
}

@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Text(text = "+", fontSize = 24.sp)
    }
}
