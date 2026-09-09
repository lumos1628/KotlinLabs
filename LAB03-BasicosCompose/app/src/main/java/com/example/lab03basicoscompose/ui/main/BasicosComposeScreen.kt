package com.example.lab03basicoscompose.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab03basicoscompose.R
import com.example.lab03basicoscompose.theme.LAB03BasicosComposeTheme

/**
 * Módulo: Conceptos básicos de Compose.
 * Incluye ejercicios introductorios: Hola mundo, contador, saludo personalizado,
 * lista simple, tarjeta con imagen y uso básico de Modifier.
 */
@Composable
fun BasicosComposeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Conceptos Básicos de Compose",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        EjercicioHolaMundo()
        EjercicioContador()
        EjercicioSaludoPersonalizado()
        EjercicioListaSimple()
        EjercicioTarjetaConImagen()
        EjercicioModifiers()
    }
}

/**
 * Ejercicio 1: Hola Mundo con Compose.
 * Concepto: un composable reutilizable que recibe parámetros.
 */
@Composable
fun EjercicioHolaMundo() {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("1. Hola Mundo", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Hola, Compose!")
        }
    }
}

/**
 * Ejercicio 2: Contador con estado.
 * Concepto: estado (remember + mutableStateOf) y recomposición.
 */
@Composable
fun EjercicioContador() {
    var contador by remember { mutableIntStateOf(0) }

    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("2. Contador", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Valor: $contador", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(onClick = { contador-- }) { Text("-") }
                Button(onClick = { contador++ }) { Text("+") }
            }
        }
    }
}

/**
 * Ejercicio 3: Saludo personalizado.
 * Concepto: TextField ligado a estado y composables reutilizables.
 */
@Composable
fun EjercicioSaludoPersonalizado() {
    var nombre by remember { mutableStateOf("") }

    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("3. Saludo Personalizado", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Tu nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (nombre.isNotBlank()) {
                Text(
                    text = "¡Hola, $nombre!",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

/**
 * Ejercicio 4: Lista simple con Column.
 * Concepto: iterar sobre una colección para generar UI.
 */
@Composable
fun EjercicioListaSimple() {
    val lenguajes = listOf("Kotlin", "Java", "Python", "Swift", "Dart")

    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("4. Lista Simple", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            lenguajes.forEach { lenguaje ->
                Text("• $lenguaje")
            }
        }
    }
}

/**
 * Ejercicio 5: Tarjeta con imagen.
 * Concepto: uso de Image con painterResource y Card.
 */
@Composable
fun EjercicioTarjetaConImagen() {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("5. Tarjeta con Imagen", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = "Logo",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Android + Jetpack Compose")
        }
    }
}

/**
 * Ejercicio 6: Uso básico de Modifier.
 * Concepto: encadenar modificadores para tamaño, fondo, padding, forma, etc.
 */
@Composable
fun EjercicioModifiers() {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("6. Modificadores", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Caja con modificadores",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .clip(RoundedCornerShape(12.dp))
                    .padding(16.dp),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )
        }
    }
}

// ===================== PREVIEW =====================

@Preview(showBackground = true, name = "Conceptos Básicos de Compose")
@Composable
fun BasicosComposeScreenPreview() {
    LAB03BasicosComposeTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            BasicosComposeScreen()
        }
    }
}
