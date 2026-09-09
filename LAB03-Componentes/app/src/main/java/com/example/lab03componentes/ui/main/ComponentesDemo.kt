package com.example.lab03componentes.ui.main

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab03componentes.R
import com.example.lab03componentes.theme.LAB03ComponentesTheme

/**
 * Demo general que muestra todos los componentes en una columna scrolleable.
 * Cada componente también tiene su propia Preview más abajo.
 */
@Composable
fun ComponentesDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Exploración de Componentes",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        DemoColumn()
        DemoRow()
        DemoBox()
        DemoText()
        DemoButton()
        DemoTextField()
        DemoImage()
        DemoSpacer()
        DemoCard()
    }
}

/**
 * Column: organiza elementos en vertical.
 * Atributos clave: verticalArrangement, horizontalAlignment, modifier.
 */
@Composable
fun DemoColumn() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Dentro de un Column", fontWeight = FontWeight.Bold)
        Text("Elemento 1")
        Text("Elemento 2")
    }
}

/**
 * Row: organiza elementos en horizontal.
 * Atributos clave: horizontalArrangement, verticalAlignment.
 */
@Composable
fun DemoRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Izquierda")
        Text("Centro")
        Text("Derecha")
    }
}

/**
 * Box: apila elementos uno encima de otro.
 * Atributos clave: contentAlignment, permite superposición de contenido.
 */
@Composable
fun DemoBox() {
    Box(
        modifier = Modifier.size(80.dp),
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        )
        Text("Box", color = Color.DarkGray, fontWeight = FontWeight.Bold)
    }
}

/**
 * Text: muestra texto.
 * Atributos clave: fontSize, fontWeight, color, textAlign.
 */
@Composable
fun DemoText() {
    Column {
        Text("Texto normal")
        Text("Texto grande", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Texto coloreado", color = MaterialTheme.colorScheme.primary)
    }
}

/**
 * Button: botón interactivo.
 * Atributos clave: onClick, shape, colors, enabled.
 */
@Composable
fun DemoButton() {
    var clicks by remember { mutableStateOf(0) }
    Button(onClick = { clicks++ }) {
        Text("Clics: $clicks")
    }
}

/**
 * TextField: campo de entrada de texto.
 * Atributos clave: value, onValueChange, label, placeholder.
 */
@Composable
fun DemoTextField() {
    var texto by remember { mutableStateOf("") }
    OutlinedTextField(
        value = texto,
        onValueChange = { texto = it },
        label = { Text("Escribe algo") },
        modifier = Modifier.fillMaxWidth()
    )
}

/**
 * Image: muestra una imagen.
 * Atributos clave: painter, contentDescription, modifier.
 */
@Composable
fun DemoImage() {
    Image(
        painter = painterResource(id = R.drawable.img_ejemplo),
        contentDescription = "Imagen de ejemplo",
        modifier = Modifier.size(64.dp)
    )
}

/**
 * Spacer: añade espacio vacío entre elementos.
 * Atributos clave: modifier con height o width.
 */
@Composable
fun DemoSpacer() {
    Column {
        Text("Arriba")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Abajo (con 16dp de espacio)")
    }
}

/**
 * Card: contenedor con elevación y bordes redondeados.
 * Atributos clave: elevation, shape, colors.
 */
@Composable
fun DemoCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Título de la tarjeta", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Contenido dentro de una tarjeta.")
        }
    }
}

// ===================== PREVIEWS INDIVIDUALES =====================

@Preview(showBackground = true, name = "Demo Column")
@Composable
fun PreviewDemoColumn() {
    LAB03ComponentesTheme { DemoColumn() }
}

@Preview(showBackground = true, name = "Demo Row")
@Composable
fun PreviewDemoRow() {
    LAB03ComponentesTheme { DemoRow() }
}

@Preview(showBackground = true, name = "Demo Box")
@Composable
fun PreviewDemoBox() {
    LAB03ComponentesTheme { DemoBox() }
}

@Preview(showBackground = true, name = "Demo Text")
@Composable
fun PreviewDemoText() {
    LAB03ComponentesTheme { DemoText() }
}

@Preview(showBackground = true, name = "Demo Button")
@Composable
fun PreviewDemoButton() {
    LAB03ComponentesTheme { DemoButton() }
}

@Preview(showBackground = true, name = "Demo TextField")
@Composable
fun PreviewDemoTextField() {
    LAB03ComponentesTheme { DemoTextField() }
}

@Preview(showBackground = true, name = "Demo Image")
@Composable
fun PreviewDemoImage() {
    LAB03ComponentesTheme { DemoImage() }
}

@Preview(showBackground = true, name = "Demo Spacer")
@Composable
fun PreviewDemoSpacer() {
    LAB03ComponentesTheme { DemoSpacer() }
}

@Preview(showBackground = true, name = "Demo Card")
@Composable
fun PreviewDemoCard() {
    LAB03ComponentesTheme { DemoCard() }
}

@Preview(showBackground = true, name = "Vista General")
@Composable
fun PreviewComponentesDemo() {
    LAB03ComponentesTheme { ComponentesDemo() }
}
