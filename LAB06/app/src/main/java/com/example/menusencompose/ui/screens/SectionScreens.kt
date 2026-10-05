package com.example.menusencompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SectionScreen(title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = title)
    }
}

@Composable
fun BuildScreen(modifier: Modifier = Modifier) = SectionScreen("Vista Build", modifier)

@Composable
fun MenuScreen(modifier: Modifier = Modifier) = SectionScreen("Vista Menu", modifier)

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier) = SectionScreen("Vista Favorite", modifier)

@Composable
fun DeleteScreen(modifier: Modifier = Modifier) = SectionScreen("Vista Delete", modifier)
