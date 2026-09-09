package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContent es el puente entre la Activity y Compose.
        // Todo lo que pongamos adentro es lo que se ve en pantalla.
        setContent {
            MyApplicationTheme {
                PantallaEjemplo()
            }
        }
    }
}

// =====================================================================
// COMPOSABLE = funcion con @Composable que dibuja parte de la interfaz.
// Puede recibir parametros y puede contener otros composables adentro.
// =====================================================================
@Composable
fun PantallaEjemplo(modifier: Modifier = Modifier) {
    // Column coloca los elementos en VERTICAL, uno debajo del otro.
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Mi primera app Compose",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Card = "tarjeta" que agrupa contenido en un recuadro.
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            // Contador: usa ESTADO. El estado es lo que Compose
            // "observa" para redibujarse cuando cambia.
            Contador()
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Saludo()
        }
    }
}

// =====================================================================
// ESTADO + RECOMPOSICION:
//  - remember guarda el valor mientras la pantalla esta visible.
//  - mutableStateOf hace que Compose "vigile" la variable.
//  - Cuando contador cambia, Compose recompone (redibuja) SOLO lo
//    que depende de contador.
//  - "by" (delegate) nos deja usar "contador" y "contador++"
//    sin escribir .value por todos lados.
// =====================================================================
@Composable
fun Contador() {
    var contador by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Contador",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Row coloca los elementos en HORIZONTAL, uno al lado del otro.
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Button: al hacer clic ejecuta onClick.
            Button(onClick = { contador-- }) { Text("-") }
            Text(
                text = "Valor: $contador",
                style = MaterialTheme.typography.titleLarge
            )
            Button(onClick = { contador++ }) { Text("+") }
        }
    }
}

// =====================================================================
// TextField + parametros:
//  - OutlinedTextField = caja donde el usuario escribe.
//  - value = lo que hay escrito. onValueChange = lo que pasa
//    mientras escribe. Es un "estado ligado".
//  - Greeting es un composable REUTILIZABLE: recibe el nombre como
//    parametro y decide que mostrar.
// =====================================================================
@Composable
fun Saludo() {
    // El TextField tiene su propio estado: lo que el usuario escribe.
    var nombre by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Saludo",
            style = MaterialTheme.typography.titleLarge
            painterResouce
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = nombre,
            onValueChange = { nuevoTexto -> nombre = nuevoTexto },
            label = { Text("Escribe tu nombre") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        // El composable Greeting recibe nombre como parametro.
        // Si esta vacio mostramos un mensaje, si no, saludamos.
        if (nombre.isBlank()) {
            Text("Escribe algo arriba para ver el saludo")
        } else {
            Greeting(name = nombre)
        }
    }
}

// Composable reutilizable: recibe un nombre y lo muestra.
// Los composables se pueden llamar desde cualquier parte de la UI.
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola $name!",
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium
    )
}

// @Preview: se ve en Android Studio (pestaña Split/Design)
// sin necesidad de ejecutar la app en el telefono.
@Preview(showBackground = true)
@Composable
fun PantallaEjemploPreview() {
    MyApplicationTheme {
        PantallaEjemplo()
    }
}