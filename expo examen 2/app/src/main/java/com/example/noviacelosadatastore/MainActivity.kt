package com.example.noviacelosadatastore

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.emptyPreferences
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

private const val NOTIFICATION_CHANNEL_ID = "novia_celosa_messages"
private const val NOTIFICATION_ID_BASE = 4100

private val Context.demoDataStore by preferencesDataStore(name = "novia_demo_preferences")
private val DARK_MODE = booleanPreferencesKey("modo_oscuro")
private val SHOW_MESSAGES = booleanPreferencesKey("mostrar_mensajes")

private data class DemoSettings(
    val darkMode: Boolean = false,
    val showMessages: Boolean = true,
)

private val jealousMessages = listOf(
    "¿Dónde estás? 😒",
    "¿Con quién estás? 👀",
    "¿Por qué no contestas? 📱",
    "Te veo en línea…",
    "¿Quién te dio like? 🤨",
    "Avísame cuando llegues.",
    "¿Ya viste mis mensajes?",
    "Solo pregunto… ¿quién es ella?",
    "Bueno, ya no te escribo 🙄",
    "¿A qué hora llegas? ❤️",
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        createNotificationChannel(this)
        setContent {
            JealousDemo(dataStore = demoDataStore)
        }
    }
}

@Composable
private fun JealousDemo(dataStore: DataStore<Preferences>) {
    val context = LocalContext.current
    val settingsFlow: Flow<DemoSettings?> = dataStore.data
        .catch { error ->
            if (error is IOException) emit(emptyPreferences()) else throw error
        }
        .map<Preferences, DemoSettings?> { prefs ->
            DemoSettings(
                darkMode = prefs[DARK_MODE] ?: false,
                showMessages = prefs[SHOW_MESSAGES] ?: true,
            )
        }
    val storedSettings by settingsFlow.collectAsState(initial = null)
    val settings = storedSettings ?: DemoSettings()
    val scope = rememberCoroutineScope()
    var notificationsAllowed by remember { mutableStateOf(hasNotificationPermission(context)) }
    var pendingSimulationAfterPermission by remember { mutableStateOf(false) }
    var simulationRequested by remember { mutableStateOf(false) }
    var simulationRunId by remember { mutableIntStateOf(0) }
    var sentMessages by remember { mutableIntStateOf(0) }
    var isSending by remember { mutableStateOf(false) }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { granted ->
        notificationsAllowed = granted
        if (pendingSimulationAfterPermission) {
            pendingSimulationAfterPermission = false
            if (granted && settings.showMessages) {
                cancelSimulationNotifications(context)
                sentMessages = 0
                isSending = true
                simulationRequested = true
                simulationRunId += 1
            }
        }
    }

    val startOrRestartSimulation = {
        if (settings.showMessages) {
            if (notificationsAllowed) {
                cancelSimulationNotifications(context)
                sentMessages = 0
                isSending = true
                simulationRequested = true
                simulationRunId += 1
            } else {
                pendingSimulationAfterPermission = true
                permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }

    LaunchedEffect(simulationRunId, simulationRequested, notificationsAllowed, settings.showMessages) {
        val manager = NotificationManagerCompat.from(context)
        if (!settings.showMessages) {
            cancelSimulationNotifications(context)
            simulationRequested = false
            isSending = false
            return@LaunchedEffect
        }
        if (!simulationRequested || simulationRunId == 0 || !notificationsAllowed) {
            return@LaunchedEffect
        }

        jealousMessages.forEachIndexed { index, message ->
            if (!hasNotificationPermission(context)) {
                isSending = false
                simulationRequested = false
                return@LaunchedEffect
            }
            val notification = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Novia • WhatsApp")
                .setContentText(message)
                .setStyle(NotificationCompat.BigTextStyle().bigText(message))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setAutoCancel(false)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .build()
            manager.notify(NOTIFICATION_ID_BASE + index, notification)
            sentMessages = index + 1
            if (index < jealousMessages.lastIndex) delay(2_000)
        }
        isSending = false
    }

    val colors = if (settings.darkMode) {
        darkColorScheme(
            primary = Color(0xFF69D5C0),
            background = Color(0xFF101817),
            surface = Color(0xFF1B2523),
            onSurface = Color(0xFFE5F0ED),
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF087E70),
            background = Color(0xFFF3F7F6),
            surface = Color.White,
            onSurface = Color(0xFF172321),
        )
    }

    MaterialTheme(colorScheme = colors) {
        Scaffold(containerColor = MaterialTheme.colorScheme.background) { insets ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(insets)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 18.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
            ) {
                Header()
                SettingCard(
                    emoji = "🌙",
                    title = "Modo oscuro",
                    subtitle = "Preferencia guardada con DataStore",
                    checked = settings.darkMode,
                    onCheckedChange = { enabled ->
                        scope.launch { dataStore.edit { it[DARK_MODE] = enabled } }
                    },
                )
                SettingCard(
                    emoji = "🔕",
                    title = "Silenciar mensajes",
                    subtitle = if (settings.showMessages) "Que siga escribiendo…" else "Paz por fin 😌",
                    checked = !settings.showMessages,
                    onCheckedChange = { muted ->
                        scope.launch { dataStore.edit { it[SHOW_MESSAGES] = !muted } }
                    },
                )
                Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(9.dp),
                    ) {
                        val simulationStatus = when {
                            !settings.showMessages -> "Activa los mensajes para iniciar la simulación."
                            isSending -> "Enviadas $sentMessages de ${jealousMessages.size} notificaciones…"
                            sentMessages == jealousMessages.size -> "¡Listo! Puedes reiniciar la secuencia cuando quieras."
                            !notificationsAllowed -> "Al iniciar, Android pedirá permiso para mostrar notificaciones."
                            else -> "Pulsa para enviar diez mensajes al dispositivo, uno cada dos segundos."
                        }
                        Text(simulationStatus, style = MaterialTheme.typography.bodySmall)
                        if (isSending) {
                            LinearProgressIndicator(
                                progress = { sentMessages / jealousMessages.size.toFloat() },
                                modifier = Modifier.fillMaxWidth(),
                            )
                        }
                        Button(
                            onClick = startOrRestartSimulation,
                            enabled = settings.showMessages,
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(
                                when {
                                    !settings.showMessages -> "Mensajes silenciados"
                                    isSending -> "Reiniciar envío ($sentMessages/10)"
                                    sentMessages == jealousMessages.size -> "Reiniciar notificaciones"
                                    else -> "Iniciar notificaciones"
                                },
                            )
                        }
                    }
                }
                Text(
                    text = if (settings.showMessages) "📲  10 MENSAJES SIN LEER" else "🤫  MENSAJES SILENCIADOS",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary,
                )
                if (settings.showMessages) {
                    jealousMessages.forEachIndexed { index, message ->
                        MessageCard(message = message, index = index)
                    }
                } else {
                    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
                        Text(
                            text = "Notificaciones canceladas. DataStore recordará que las silenciaste.",
                            modifier = Modifier.padding(18.dp),
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                }
                LearningCard()
                Spacer(Modifier.height(10.dp))
            }
        }
    }
}

private fun cancelSimulationNotifications(context: Context) {
    val manager = NotificationManagerCompat.from(context)
    jealousMessages.indices.forEach { manager.cancel(NOTIFICATION_ID_BASE + it) }
}

private fun hasNotificationPermission(context: Context): Boolean =
    Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.POST_NOTIFICATIONS,
    ) == PackageManager.PERMISSION_GRANTED

private fun createNotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            "Mensajes de la novia",
            NotificationManager.IMPORTANCE_HIGH,
        ).apply {
            description = "Mensajes de demostración para la exposición de DataStore"
            setSound(null, null)
            enableVibration(false)
        }
        context.getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
    }
}

@Composable
private fun Header() {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text("LA NOVIA CELOSA", fontSize = 27.sp, fontWeight = FontWeight.Black, color = MaterialTheme.colorScheme.primary)
        Text("Una demo con memoria… cortesía de DataStore 💾", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
private fun SettingCard(
    emoji: String,
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(18.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(emoji, fontSize = 25.sp)
            Column(modifier = Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold)
                Text(subtitle, style = MaterialTheme.typography.bodySmall)
            }
            Switch(checked = checked, onCheckedChange = onCheckedChange)
        }
    }
}

@Composable
private fun MessageCard(message: String, index: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 16.dp, bottomStart = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Text("💚", fontSize = 22.sp)
            Column(modifier = Modifier.weight(1f)) {
                Text("Novia • WhatsApp", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Text(message, style = MaterialTheme.typography.bodyMedium)
            }
            Text("8:${(3 + index).toString().padStart(2, '0')}", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = .6f))
        }
    }
}

@Composable
private fun LearningCard() {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary.copy(alpha = .10f)),
        shape = RoundedCornerShape(18.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("🧠 ¿QUÉ DEMUESTRA?", fontWeight = FontWeight.Black, color = MaterialTheme.colorScheme.primary)
            HorizontalDivider(color = MaterialTheme.colorScheme.primary.copy(alpha = .25f))
            Text("• Preferences DataStore guarda preferencias simples como estos interruptores; las lee de forma asíncrona con Flow.", style = MaterialTheme.typography.bodySmall)
            Text("• SharedPreferences sigue funcionando, pero DataStore es la alternativa moderna con actualizaciones transaccionales.", style = MaterialTheme.typography.bodySmall)
            Text("• Proto DataStore: objetos con esquema definido. Room: listas y consultas. Archivos: fotos. Nube: sincronización.", style = MaterialTheme.typography.bodySmall)
        }
    }
}
