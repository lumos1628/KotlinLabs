package com.example.examen.ui.theme

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * ViewModel que expone el modo de tema actual y permite cambiarlo.
 */
class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val dataStore = ThemeDataStore(application.applicationContext)

    private val _themeMode = MutableStateFlow(dataStore.getThemeMode())
    val themeMode: StateFlow<ThemeMode> = _themeMode.asStateFlow()

    init {
        dataStore.themeMode
            .onEach { _themeMode.value = it }
            .launchIn(viewModelScope)
    }

    /**
     * Cambia el modo de tema y lo persiste.
     */
    fun setThemeMode(mode: ThemeMode) {
        dataStore.saveThemeMode(mode)
    }

    /**
     * Avanza al siguiente modo en el ciclo: Sistema -> Oscuro -> Claro -> Sistema.
     */
    fun toggleThemeMode() {
        val next = when (_themeMode.value) {
            ThemeMode.SYSTEM -> ThemeMode.DARK
            ThemeMode.DARK -> ThemeMode.LIGHT
            ThemeMode.LIGHT -> ThemeMode.SYSTEM
        }
        setThemeMode(next)
    }
}
