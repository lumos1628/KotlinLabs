package com.example.examen.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = NeonCyan,
    onPrimary = Color.Black,
    primaryContainer = NeonCyanSoft,
    onPrimaryContainer = NeonCyan,
    secondary = NeonGreen,
    onSecondary = Color.Black,
    secondaryContainer = NeonGreenSoft,
    onSecondaryContainer = NeonGreen,
    tertiary = NeonRed,
    onTertiary = Color.White,
    tertiaryContainer = NeonRedSoft,
    onTertiaryContainer = NeonRed,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    error = NeonRed,
    onError = Color.White,
    outline = DarkOnSurfaceVariant
)

private val LightColorScheme = lightColorScheme(
    primary = NeonCyan,
    onPrimary = Color.Black,
    primaryContainer = NeonCyanSoft,
    onPrimaryContainer = Color(0xFF006666),
    secondary = NeonGreen,
    onSecondary = Color.Black,
    secondaryContainer = NeonGreenSoft,
    onSecondaryContainer = Color(0xFF156500),
    tertiary = NeonRed,
    onTertiary = Color.White,
    tertiaryContainer = NeonRedSoft,
    onTertiaryContainer = Color(0xFF990000),
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    error = NeonRed,
    onError = Color.White,
    outline = LightOnSurfaceVariant
)

/**
 * Envuelve el contenido con el tema de la aplicación.
 *
 * @param themeMode Modo de tema solicitado. Por defecto sigue al sistema.
 * @param content Contenido composable a estilizar.
 */
@Composable
fun EXAMENTheme(
    themeMode: ThemeMode = ThemeMode.SYSTEM,
    content: @Composable () -> Unit
) {
    val darkTheme = when (themeMode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
    }

    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
