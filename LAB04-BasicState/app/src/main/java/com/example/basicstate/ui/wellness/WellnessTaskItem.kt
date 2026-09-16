package com.example.basicstate.ui.wellness

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstate.data.WellnessTask
import com.example.basicstate.theme.BasicStateTheme

/**
 * Ítem de tarea con Checkbox y estado propio.
 */
@Composable
fun WellnessTaskItem(
    task: WellnessTask,
    modifier: Modifier = Modifier
) {
    var checked by remember { mutableStateOf(false) }

    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = task.label, modifier = Modifier.weight(1f))
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    BasicStateTheme {
        WellnessTaskItem(WellnessTask(1, "Take a walk"))
    }
}