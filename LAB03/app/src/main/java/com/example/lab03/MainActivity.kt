package com.example.lab03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.lab03.ui.theme.AndroidGreen
import com.example.lab03.ui.theme.DarkGreen
import com.example.lab03.ui.theme.DarkTealBox
import com.example.lab03.ui.theme.LAB03Theme
import com.example.lab03.ui.theme.MintBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LAB03Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        TarjetaJenniferDoe()
                    }
                }
            }
        }
    }
}

/**
 * PASO 1: Tarjeta de felicitación básica.
 * Usa Column para organizar elementos verticalmente.
 */
@Composable
fun GreetingCardBasica() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¡Bienvenido A KOTLIN!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "¡Hola, DOCENTE!",
            fontSize = 20.sp
        )
    }
}

/**
 * PASO 2: Tarjeta con TextField e Image.
 * Se añade un campo de texto y una imagen decorativa.
 */
@Composable
fun GreetingCardConInput() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¡Bienvenido al Curso!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "¡Hola, Estudiante!",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Escribe tu nombre") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.img_curso),
            contentDescription = "Imagen del curso",
            modifier = Modifier.size(100.dp)
        )
    }
}

/**
 * PASO 3: Tarjeta con botón personalizado.
 * El botón tiene color, esquinas redondeadas y texto personalizado.
 */
@Composable
fun GreetingCardConBoton() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¡Bienvenido al Curso!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "¡Hola, Estudiante!",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Escribe tu nombre") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Simulación de acción */ },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(
                text = "Mostrar saludo",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.img_curso),
            contentDescription = "Imagen del curso",
            modifier = Modifier.size(100.dp)
        )
    }
}

/**
 * PASO 4: Tarjeta final con Column y Row.
 * Los botones Aceptar y Rechazar se organizan horizontalmente.
 */
@Composable
fun GreetingCardFinal() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¡Bienvenido al Curso!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "¡Hola, Estudiante!",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        var nombre by remember { mutableStateOf("") }
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Escribe tu nombre") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = { /* Acción aceptar */ },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("Aceptar")
            }
            Button(
                onClick = { /* Acción rechazar */ },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                )
            ) {
                Text("Rechazar")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.img_curso),
            contentDescription = "Imagen del curso",
            modifier = Modifier.size(100.dp)
        )
        if (nombre.isNotBlank()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "¡Hola, $nombre!",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

/**
 * EJERCICIO: Recrear la vista de la tarjeta de presentación.
 * Muestra una imagen, título de bienvenida, campo para el nombre,
 * dos botones de acción y un saludo personalizado.
 */
@Composable
fun TarjetaPresentacion() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_curso),
            contentDescription = "Presentación",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Bienvenido al Curso",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Registra tu nombre para continuar",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        var nombre by remember { mutableStateOf("") }
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Tu nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* Guardar nombre */ },
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Guardar")
            }
            Button(
                onClick = { nombre = "" },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Text("Borrar")
            }
        }
        if (nombre.isNotBlank()) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "¡Hola, $nombre!",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

/**
 * TARJETA DE PRESENTACIÓN - Jennifer Doe
 * Réplica de la tarjeta de presentación mostrada en la imagen.
 * Fondo verde menta, logo Android en caja verde azulado oscuro,
 * nombre con fuente ligera y datos de contacto alineados.
 */
@Composable
fun TarjetaJenniferDoe() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MintBackground)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Sección superior centrada verticalmente
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Caja con logo Android
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(DarkTealBox),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.img_android_logo),
                        contentDescription = "Logo de Android",
                        modifier = Modifier.size(80.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "android",
                        color = AndroidGreen,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Kary Doe",
                fontSize = 40.sp,
                fontWeight = FontWeight.Thin,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = DarkGreen
            )
        }

        // Sección inferior de información de contacto
        Column(
            modifier = Modifier.padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FilaContacto(
                iconoRes = R.drawable.ic_phone,
                texto = "+11 (123) 444 555 666"
            )
            FilaContacto(
                iconoRes = R.drawable.ic_share,
                texto = "@AndroidDev"
            )
            FilaContacto(
                iconoRes = R.drawable.ic_email,
                texto = "jen.doe@android.com"
            )
        }
    }
}

/**
 * Fila de contacto con icono y texto alineados.
 */
@Composable
fun FilaContacto(iconoRes: Int, texto: String) {
    Row(
        modifier = Modifier.fillMaxWidth(0.8f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconoRes),
            contentDescription = null,
            tint = DarkGreen,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = texto,
            color = Color.Black,
            fontSize = 16.sp
        )
    }
}

// ===================== PREVIEWS =====================

@Preview(showBackground = true, name = "Tarjeta Jennifer Doe")
@Composable
fun TarjetaJenniferDoePreview() {
    LAB03Theme {
        TarjetaJenniferDoe()
    }
}

@Preview(showBackground = true, name = "Paso 1 - Básica")
@Composable
fun GreetingCardBasicaPreview() {
    LAB03Theme {
        GreetingCardBasica()
    }
}

@Preview(showBackground = true, name = "Paso 2 - Input e Image")
@Composable
fun GreetingCardConInputPreview() {
    LAB03Theme {
        GreetingCardConInput()
    }
}

@Preview(showBackground = true, name = "Paso 3 - Con Botón")
@Composable
fun GreetingCardConBotonPreview() {
    LAB03Theme {
        GreetingCardConBoton()
    }
}

@Preview(showBackground = true, name = "Paso 4 - Final")
@Composable
fun GreetingCardFinalPreview() {
    LAB03Theme {
        GreetingCardFinal()
    }
}

@Preview(showBackground = true, name = "Ejercicio - Tarjeta Presentación")
@Composable
fun TarjetaPresentacionPreview() {
    LAB03Theme {
        TarjetaPresentacion()
    }
}
