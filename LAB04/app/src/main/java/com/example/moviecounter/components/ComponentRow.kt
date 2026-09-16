package com.example.moviecounter.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviecounter.theme.MovieCounterTheme

/**
 * Demo de Row: organiza elementos horizontalmente, uno al lado del otro.
 */
@Composable
fun DemoRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "A")
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "B")
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "C")
    }
}

@Preview(showBackground = true)
@Composable
fun DemoRowPreview() {
    MovieCounterTheme {
        DemoRow()
    }
}