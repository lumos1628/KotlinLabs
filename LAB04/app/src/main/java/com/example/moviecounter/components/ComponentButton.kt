package com.example.moviecounter.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviecounter.theme.MovieCounterTheme

/**
 * Demo de Button: componente interactivo que responde a clics del usuario.
 */
@Composable
fun DemoButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(16.dp)
    ) {
        Text(text = "Press me")
    }
}

@Preview(showBackground = true)
@Composable
fun DemoButtonPreview() {
    MovieCounterTheme {
        DemoButton(onClick = {})
    }
}