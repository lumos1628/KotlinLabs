# Laboratorio 06: Uso de Menús en una Aplicación Android
**Curso: Programación en Móviles — TECSUP**
**Docente:** Benjamin Pareja | **Programa:** Diseño y Desarrollo de Software | **2025 - Sur**

> Nota de conversión: versión en texto/Markdown del formato Word en blanco, para que una IA (o tú) la entienda fácilmente.

[IMAGEN — Portada del informe]
Misma portada institucional de TECSUP vista en laboratorios anteriores del curso: fondo blanco con formas geométricas de colores (naranja, morado, azul) a la derecha, logo de TECSUP arriba a la izquierda, título "INFORME DE LABORATORIO", la mascota de Android sosteniendo el logo de Kotlin al centro, y debajo "PROGRAMACIÓN EN MÓVILES", "Docente: Benjamin Pareja", "Programa: Diseño y Desarrollo de Software", "2025 - Sur".

[IMAGEN — Logo "Android Developers"]
El mismo logo del robot de Android junto al texto "Developers" en gris, decorativo, cerca del inicio del documento.

---

| Alumno(s): | | Nota | |
|---|---|---|---|
| Grupo: | | Ciclo: | |

| Criterio de Evaluación | Excelente (4pts) | Bueno (3pts) | Requiere mejora (2pts) | No acept. (0pts) | Puntaje Logrado |
|---|---|---|---|---|---|
| Realiza la parte guiada del laboratorio (parte 1) | | | | | **6** |
| Desarrolla el ejercicio (parte 2) | | | | | **4** |
| Desarrolla el ejercicio (parte 3) | | | | | **5** |
| Realiza observaciones y conclusiones que aporten una opinión crítica y técnica | | | | | **3** |
| Es puntual y redacta el informe adecuadamente sin copias de otros autores | | | | | **2** |

## Laboratorio 06: Uso de Menús en una Aplicación Android

### Objetivo
- Introducción a los Menús en Jetpack Compose

### Seguridad
- No ingresar con líquidos, ni comida al aula de Laboratorio.
- Al culminar la sesión de laboratorio apagar correctamente la computadora y la pantalla, y ordenar las sillas utilizadas.

### Equipos y Materiales
- Sistema Operativo Windows 10 o superior con conexión a la red del laboratorio.
- Android Studio o algún otro entorno de desarrollo donde se pueda correr aplicaciones móviles basadas en Kotlin y Jetpack Compose.

---

## DESARROLLO

### Parte 1: Ejercicio Guiado para crear una plantilla básica

**Elementos de scaffold**

Los elementos que se pueden utilizar en un scaffold son los siguientes:
- **Top app bar**: es la barra de la parte superior
- **Content**: el contenido principal de la aplicación
- **FAB** (Floating Action Button): botón flotante
- **Bottom Bar**: es la barra de la parte inferior, o barra de navegación
- **Drawer**: es el menú lateral que se expande/contrae

Todos ellos son opcionales y personalizables; para hacer utilizar cada elemento, debemos generar un Composable para dicho elemento, como veremos en el uso básico.

**Uso básico**

Función que define el Scaffold:

```kotlin
// Función Composable que crea un Scaffold personalizado
@Composable
fun CustomScaffold() {
    Scaffold(
        // Barra superior
        topBar = { CustomTopBar() },
        // Barra inferior
        bottomBar = { CustomBottomBar() },
        // Botón flotante personalizado
        floatingActionButton = { CustomFAB() },
        // Contenido principal
        content = { padding ->
            CustomContent(padding)
        }
    )
}
```

La función Scaffold tiene bastantes parámetros, yo en este caso he utilizado los siguientes:
- **topBar**: hace referencia a la barra superior, acepta un Composable de tipo TopAppBar
- **bottomBar**: hace referencia a la barra inferior, por lo general su uso está destinado a la navegación dentro de la aplicación, acepta un Composable BottomAppBar
- **floatingActionButton**: es el botón flotante que se encuentra por encima de todos los demás elementos, se permite fusionar con la barra inferior, acepta un FloatingActionButton
- **content**: hace referencia al contenido principal de la aplicación, se puede poner cualquier Composable pero se suelen poner filas, columnas, surface, box, etc. En el ejemplo he utilizado Column

**Pregunta:** ¿Existen más elementos o componentes de scaffold que Material 3 nos aconseje usar?

`[Espacio en blanco para que el alumno responda]`

Estos cuatro parámetros aceptan funciones de tipo `@Composable` las que muestro a continuación:

**Barra superior**

```kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar() {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null
                )
            }
        }
    )
}
```

**Ejercicio:** Crea otra vista de perfil de usuario, y vincularla mediante navegación al botón que usa el imageVector "Icons.Outlined.AccountCircle".

`[Espacio en blanco para que el alumno documente el proceso]`

**Barra inferior**

```kotlin
@Composable
fun CustomBottomBar() {
    BottomAppBar {
        IconButton(onClick = { print("Build") }) {
            Icon(Icons.Filled.Build, contentDescription = "Build description")
        }
        IconButton(onClick = { print("Menu") }) {
            Icon(
                Icons.Filled.Menu,
                contentDescription = "Menu description",
            )
        }
        IconButton(onClick = { print("Favorite") }) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite description",
            )
        }
        IconButton(onClick = { print("Delete") }) {
            Icon(
                Icons.Filled.Delete,
                contentDescription = "Delete description",
            )
        }
    }
}
```

**Ejercicio:** Haz ajustes en los botones para que no estén apilados a la izquierda, sino que se distribuyan de forma uniforme para todo el largo de la pantalla.

`[Espacio en blanco para que el alumno documente el proceso]`

**Ejercicio:** Modifica los iconos a tu gusto, y crea una vista nueva que esté vinculada a cada botón. Realiza su navegación correspondiente.

`[Espacio en blanco para que el alumno documente el proceso]`

**Botón flotante**

```kotlin
@Composable
fun CustomFAB() {
    FloatingActionButton(
        // Color de fondo
        //backgroundColor = MaterialTheme.colors.primary,
        // Acción al hacer clic en el botón (sin definir)
        onClick = { /*TODO*/ }) {
        Text(
            fontSize = 24.sp, // Tamaño de fuente del texto del botón
            text = "+" // Texto del botón
        )
    }
}
```

**Ejercicio:** Usa los conocimientos de **estados** obtenidos en los laboratorios anteriores para modificar la función de ese botón. El objetivo es que cada vez que el usuario apriete el botón, se modifique una variable de la pantalla principal que muestre cuántas veces apretaste el botón.

`[Espacio en blanco para que el alumno documente el proceso]`

**Contenido principal**

```kotlin
@Composable
fun CustomContent(padding: PaddingValues) {
    Column(
        // Modificadores de estilo de la columna
        modifier = Modifier
            // Ocupar todo el espacio disponible
            .fillMaxSize()
            .padding(padding),
        // Contenido de la aplicación
        content = {
            Text(text = "My app content")
        }
    )
}
```

Muestra los resultados de toda la aplicación. Comparte un video con el funcionamiento de la aplicación:

`[Espacio en blanco para que el alumno adjunte su video/evidencia]`

---

### Parte 2: Ejercicio

Realiza el codelab sobre [Temas en Compose con Material 3](https://developer.android.com/codelabs/basic-android-kotlin-compose-material-theming?hl=es-419&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-3-pathway-3%3Fhl%3Des-419%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-material-theming#0)

`[Espacio en blanco para que el alumno documente el proceso]`

Explica:
- Qué son los temas en Material Design 3.
- Qué subsistemas tiene Material Design 3.
- ¿Por qué es importante la creación de temas para tu aplicación?

`[Espacio en blanco para que el alumno responda]`

---

### Parte 3: Ejercicio

En base a la documentación de Material Design 3, tu criterio y tus gustos personales, define cuál será el tema de tu aplicación (proyecto final). Entre los aspectos importantes debemos mencionar:
- El esquema de colores
- La tipografía
- Las formas

Adicionalmente podrías ir comentando qué estilo de transiciones usarías, qué tipo de iconos, etc.

`[Espacio en blanco para que el alumno responda]`

Diseña por lo menos 4 vistas principales de tu proyecto final en Figma usando el [Design kit de Material 3](https://www.figma.com/community/file/1035203688168086460) basado en tu tema.

`[Espacio en blanco para que el alumno adjunte sus vistas de Figma]`

---

### Puntos adicionales

Desarrolla el [módulo](https://developer.android.com/codelabs/jetpack-compose-theming?hl=es-419#0) "Temas de Material con Jetpack Compose" y comparte la solución aquí. (2 ptos)

`[Espacio en blanco para que el alumno documente el proceso]`

---

**OBSERVACIONES (5 mínimo):**
*(Las observaciones son las notas aclaratorias, objeciones y problemas que se pudo presentar en el desarrollo del laboratorio)*

`[Espacio en blanco para que el alumno complete]`

**CONCLUSIONES (5 mínimo):**
*(Las conclusiones son una opinión personal sobre tu trabajo, explicar cómo resolviste las dudas o problemas presentados en el laboratorio. Además de aportar una opinión crítica de lo realizado)*

`[Espacio en blanco para que el alumno complete]`

---

### Anexos

Bloque de imports (Kotlin) provisto como referencia para el ejercicio de la Parte 1:

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.menusencompose.ui.theme.MenusEnComposeTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.unit.sp
```
