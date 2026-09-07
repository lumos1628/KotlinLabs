package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.SettingsSuggest
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examen.ui.theme.EXAMENTheme
import com.example.examen.ui.theme.NeonCyan
import com.example.examen.ui.theme.NeonGreen
import com.example.examen.ui.theme.NeonRed
import com.example.examen.ui.theme.ThemeMode
import com.example.examen.ui.theme.ThemeViewModel
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    private val themeViewModel: ThemeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeMode by themeViewModel.themeMode.collectAsState()

            EXAMENTheme(themeMode = themeMode) {
                PantallaPomodoro(
                    themeMode = themeMode,
                    onToggleTheme = { themeViewModel.toggleThemeMode() }
                )
            }
        }
    }
}

val mensajesMotivadores = listOf(
    "¡Buen trabajo! Descanso merecido ☕",
    "¡Lo estás logrando! Sigue así 💪",
    "Un pomodoro más cerca de la meta 🎯",
    "¡Imparable! 🔥"
)

// =====================================================================
// PANTALLA PRINCIPAL DEL POMODORO
// =====================================================================
@Composable
fun PantallaPomodoro(
    themeMode: ThemeMode = ThemeMode.SYSTEM,
    onToggleTheme: () -> Unit = {}
) {
    // ---------------- ESTADO ----------------
    var trabajoMin by remember { mutableStateOf(25) }
    var descansoMin by remember { mutableStateOf(5) }

    var descanso by remember { mutableStateOf(false) }
    var corriendo by remember { mutableStateOf(false) }
    var segundos by remember { mutableStateOf(trabajoMin * 60) }
    var totalSegundos by remember { mutableStateOf(trabajoMin * 60) }
    var pomodoros by remember { mutableStateOf(0) }
    var mensaje by remember { mutableStateOf("¡Concéntrate y dale! 🚀") }

    val haptic = LocalHapticFeedback.current
    val esOscuro = MaterialTheme.colorScheme.background == com.example.examen.ui.theme.DarkBackground

    // ---------------- TEMPORIZADOR ----------------
    LaunchedEffect(corriendo) {
        while (corriendo) {
            delay(1000)
            segundos--
            if (segundos <= 0) {
                if (!descanso) {
                    pomodoros++
                    mensaje = mensajesMotivadores[pomodoros % mensajesMotivadores.size]
                }
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                descanso = !descanso
                segundos = (if (descanso) descansoMin else trabajoMin) * 60
                totalSegundos = segundos
            }
        }
    }

    // ---------------- COLORES NEON POR FASE ----------------
    val colorFase = when {
        descanso -> NeonGreen
        else -> NeonRed
    }

    val colorFondo = MaterialTheme.colorScheme.background
    val colorSuperficie = MaterialTheme.colorScheme.surface

    // ---------------- ACCIONES ----------------
    val reiniciar: () -> Unit = {
        corriendo = false
        descanso = false
        segundos = trabajoMin * 60
        totalSegundos = segundos
        mensaje = "¡Concéntrate y dale! 🚀"
    }
    val saltar: () -> Unit = {
        descanso = !descanso
        segundos = (if (descanso) descansoMin else trabajoMin) * 60
        totalSegundos = segundos
    }

    // ---------------- UI ----------------
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
            .systemBarsPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Barra superior con título e interruptor de tema
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Pomodoro Neon",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = onToggleTheme) {
                val icon = when (themeMode) {
                    ThemeMode.LIGHT -> Icons.Default.LightMode
                    ThemeMode.DARK -> Icons.Default.DarkMode
                    ThemeMode.SYSTEM -> Icons.Default.SettingsSuggest
                }
                val tint = when (themeMode) {
                    ThemeMode.LIGHT -> NeonCyan
                    ThemeMode.DARK -> NeonGreen
                    ThemeMode.SYSTEM -> NeonCyan
                }
                Icon(
                    imageVector = icon,
                    contentDescription = "Cambiar tema",
                    tint = tint
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Chip de estado
        Row(
            modifier = Modifier
                .background(colorFase.copy(alpha = 0.15f), RoundedCornerShape(50))
                .padding(horizontal = 18.dp, vertical = 8.dp)
        ) {
            Text(
                text = if (descanso) "🌿 DESCANSO" else "🍅 ENFOCADO",
                color = colorFase,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Anillo de progreso + tiempo
        Box(contentAlignment = Alignment.Center) {
            Canvas(modifier = Modifier.size(300.dp)) {
                val grosor = 18.dp.toPx()
                val radio = (size.minDimension - grosor) / 2f
                val centro = Offset(size.width / 2f, size.height / 2f)
                val topLeft = Offset(centro.x - radio, centro.y - radio)
                val dimension = Size(radio * 2, radio * 2)

                // Fondo del anillo
                drawArc(
                    color = colorFase.copy(alpha = 0.15f),
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    topLeft = topLeft,
                    size = dimension,
                    style = Stroke(width = grosor, cap = StrokeCap.Round)
                )

                // Progreso
                val progreso = if (totalSegundos > 0) segundos.toFloat() / totalSegundos.toFloat() else 1f
                drawArc(
                    color = colorFase,
                    startAngle = -90f,
                    sweepAngle = 360f * progreso,
                    useCenter = false,
                    topLeft = topLeft,
                    size = dimension,
                    style = Stroke(width = grosor, cap = StrokeCap.Round)
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = String.format("%02d:%02d", segundos / 60, segundos % 60),
                    fontSize = 58.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorFase
                )
                Text(
                    text = if (descanso) "Descanso" else "Trabajo",
                    style = MaterialTheme.typography.titleMedium,
                    color = colorFase.copy(alpha = 0.8f)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Contador de pomodoros
        Text(
            text = "Pomodoros completados",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            repeat(8) { i ->
                Text(
                    text = if (i < pomodoros) "🍅" else "⚪",
                    fontSize = 20.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = mensaje,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botones principales
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedButton(onClick = reiniciar) { Text("Reiniciar") }
            Button(
                onClick = { corriendo = !corriendo },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorFase,
                    contentColor = Color.Black
                )
            ) { Text(if (corriendo) "Pausar" else "Iniciar") }
            TextButton(onClick = saltar) { Text("Saltar") }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Selectores de duración
        Text(
            text = "Duración del ciclo",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            SelectorDuracion(
                titulo = "Trabajo",
                minutos = trabajoMin,
                color = NeonRed,
                onCambiar = { nuevo ->
                    trabajoMin = nuevo
                    if (!corriendo && !descanso) {
                        segundos = nuevo * 60
                        totalSegundos = segundos
                    }
                }
            )
            SelectorDuracion(
                titulo = "Descanso",
                minutos = descansoMin,
                color = NeonGreen,
                onCambiar = { nuevo ->
                    descansoMin = nuevo
                    if (!corriendo && descanso) {
                        segundos = nuevo * 60
                        totalSegundos = segundos
                    }
                }
            )
        }
    }
}

// Selector +/- para cambiar los minutos de una fase.
@Composable
fun SelectorDuracion(titulo: String, minutos: Int, color: Color, onCambiar: (Int) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = titulo,
            style = MaterialTheme.typography.labelMedium,
            color = color,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            FilledTonalButton(onClick = { onCambiar(minutos - 1) }, enabled = minutos > 1) {
                Text("−")
            }
            Text(
                text = "$minutos min",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyMedium
            )
            FilledTonalButton(onClick = { onCambiar(minutos + 1) }, enabled = minutos < 60) {
                Text("+")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPomodoroPreview() {
    EXAMENTheme(themeMode = ThemeMode.DARK) {
        PantallaPomodoro()
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPomodoroLightPreview() {
    EXAMENTheme(themeMode = ThemeMode.LIGHT) {
        PantallaPomodoro()
    }
}
