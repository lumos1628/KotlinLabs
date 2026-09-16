package com.example.basicstate.ui.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstate.data.WellnessTask
import com.example.basicstate.theme.BasicStateTheme

/**
 * Lista de tareas con acciones de agregar y eliminar.
 */
@Composable
fun WellnessTasksList(
    tasks: List<WellnessTask>,
    onCheckedChange: (Int, Boolean) -> Unit,
    onAddTask: (String) -> Unit,
    onRemoveTask: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var newTaskLabel by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            value = newTaskLabel,
            onValueChange = { newTaskLabel = it },
            label = { Text("New task") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                onAddTask(newTaskLabel)
                newTaskLabel = ""
            },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text("Add task")
        }
        LazyColumn {
            items(tasks, key = { it.id }) { task ->
                WellnessTaskItem(
                    task = task,
                    checked = task.checked,
                    onCheckedChange = { checked -> onCheckedChange(task.id, checked) },
                    onClose = { onRemoveTask(task.id) }
                )
            }
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
            onCheckedChange = { _, _ -> },
            onAddTask = {},
            onRemoveTask = {}
        )
    }
}