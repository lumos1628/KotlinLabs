package com.example.basicstate.ui.wellness

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstate.data.WellnessTask
import com.example.basicstate.theme.BasicStateTheme

/**
 * Lista de tareas que eleva el estado de los checkboxes.
 */
@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier
) {
    val tasks = remember {
        mutableStateListOf(
            WellnessTask(1, "Take 15 minute walk"),
            WellnessTask(2, "Drink a glass of water"),
            WellnessTask(3, "Meditate for 10 minutes"),
            WellnessTask(4, "Read a chapter of a book"),
            WellnessTask(5, "Plan the next day")
        )
    }

    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(tasks, key = { it.id }) { task ->
            WellnessTaskItem(
                task = task,
                checked = task.checked,
                onCheckedChange = { checked ->
                    val index = tasks.indexOf(task)
                    if (index != -1) {
                        tasks[index] = task.copy(checked = checked)
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTasksListPreview() {
    BasicStateTheme {
        WellnessTasksList()
    }
}