package com.example.examen.ui.theme

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged

private const val PREFS_NAME = "theme_preferences"
private const val THEME_MODE_KEY = "theme_mode"

/**
 * Gestiona la persistencia del modo de tema usando SharedPreferences.
 *
 * Para un proyecto de examen/poco tamaño SharedPreferences es suficiente,
 * rápido y evita problemas de compatibilidad con versiones de DataStore.
 */
class ThemeDataStore(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    /**
     * Flujo que emite el [ThemeMode] guardado. Si no hay nada guardado,
     * devuelve [ThemeMode.SYSTEM] por defecto.
     */
    val themeMode: Flow<ThemeMode> = callbackFlow {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            if (key == THEME_MODE_KEY) {
                trySend(getThemeMode())
            }
        }
        prefs.registerOnSharedPreferenceChangeListener(listener)
        trySend(getThemeMode())
        awaitClose { prefs.unregisterOnSharedPreferenceChangeListener(listener) }
    }.distinctUntilChanged()

    /**
     * Devuelve el modo actualmente guardado.
     */
    fun getThemeMode(): ThemeMode {
        return when (prefs.getString(THEME_MODE_KEY, ThemeMode.SYSTEM.name)) {
            ThemeMode.LIGHT.name -> ThemeMode.LIGHT
            ThemeMode.DARK.name -> ThemeMode.DARK
            else -> ThemeMode.SYSTEM
        }
    }

    /**
     * Guarda el [ThemeMode] seleccionado por el usuario.
     */
    fun saveThemeMode(mode: ThemeMode) {
        prefs.edit().putString(THEME_MODE_KEY, mode.name).apply()
    }
}
