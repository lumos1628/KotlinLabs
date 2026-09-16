package com.example.basicstate.ui.wellness

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstate.data.WellnessTask
import com.example.basicstate.theme.BasicStateTheme

/**
 * Lista controlada desde fuera: recibe los datos y los callbacks.
 */
@Composable
fun WellnessTasksList(
    tasks: List<WellnessTask>,
    onCheckedChange: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(tasks, key = { it.id }) { task ->
            WellnessTaskItem(
                task = task,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedChange(task.id, checked) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTasksListPreview() {
    BasicStateTheme {
        WellnessTasksList(
            tasks = listOf(
                WellnessTask(1, "Take a walk"),
                WellnessTask(2, "Drink water", checked = true)
            ),
            onCheckedChange = { _, _ -> }
        )
    }
}