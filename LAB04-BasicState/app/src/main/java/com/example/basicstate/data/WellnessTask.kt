package com.example.basicstate.data

/**
 * Representa una tarea de bienestar con identificador, etiqueta y estado.
 */
data class WellnessTask(
    val id: Int,
    val label: String,
    val checked: Boolean = false
)