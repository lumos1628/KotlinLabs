package com.example.basicstate.ui.wellness

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstate.data.WellnessTask
import com.example.basicstate.theme.BasicStateTheme

/**
 * Ítem de tarea con acciones: marcar y eliminar.
 */
@Composable
fun WellnessTaskItem(
    task: WellnessTask,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = task.label, modifier = Modifier.weight(1f))
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        TextButton(onClick = onClose) {
            Text("X")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    BasicStateTheme {
        WellnessTaskItem(
            task = WellnessTask(1, "Take a walk"),
            checked = false,
            onCheckedChange = {},
            onClose = {}
        )
    }
}