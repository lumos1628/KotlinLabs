package com.example.menusencompose.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun CustomScaffold(
    onProfileClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { CustomTopBar(onProfileClick = onProfileClick) },
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
