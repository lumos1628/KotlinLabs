package com.example.basicstate.ui.wellness

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.basicstate.data.WellnessTask

/**
 * ViewModel que administra la lista de tareas.
 *
 * Sobrevive a cambios de configuración y separa la lógica de la UI.
 */
class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask> get() = _tasks

    fun toggleTaskChecked(taskId: Int, checked: Boolean) {
        _tasks.find { it.id == taskId }?.let { task ->
            val index = _tasks.indexOf(task)
            _tasks[index] = task.copy(checked = checked)
        }
    }

    fun addTask(label: String) {
        if (label.isNotBlank()) {
            val newId = (_tasks.maxOfOrNull { it.id } ?: 0) + 1
            _tasks.add(WellnessTask(newId, label))
        }
    }

    fun removeTask(taskId: Int) {
        _tasks.removeAll { it.id == taskId }
    }
}

private fun getWellnessTasks() = listOf(
    WellnessTask(1, "Take 15 minute walk"),
    WellnessTask(2, "Drink a glass of water"),
    WellnessTask(3, "Meditate for 10 minutes"),
    WellnessTask(4, "Read a chapter of a book"),
    WellnessTask(5, "Plan the next day")
)