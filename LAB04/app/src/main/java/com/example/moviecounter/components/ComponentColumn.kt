package com.example.moviecounter.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviecounter.theme.MovieCounterTheme

/**
 * Demo de Column: organiza elementos verticalmente, uno debajo del otro.
 */
@Composable
fun DemoColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Item 1")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Item 2")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Item 3")
    }
}

@Preview(showBackground = true)
@Composable
fun DemoColumnPreview() {
    MovieCounterTheme {
        DemoColumn()
    }
}
