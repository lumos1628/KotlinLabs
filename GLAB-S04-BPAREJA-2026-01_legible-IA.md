# Laboratorio 04: Estados en Android
**Curso:** Programación en Móviles — TECSUP
**Docente:** Benjamin Pareja | **Programa:** Diseño y Desarrollo de Software | **2025 - Sur**

> Nota de conversión: este archivo es una versión en texto plano/Markdown del documento Word original, pensada para ser procesada por una IA. Cada imagen del documento original se reemplazó por una descripción exacta de su contenido, ubicada en el mismo punto donde aparecía. Ninguna de las imágenes contiene código fuente (son una captura de GitHub, un cuadro de referencia de componentes de Compose, y logos institucionales), así que no hay código que extraer de imágenes; todo el código del laboratorio ya estaba en formato texto (dentro de tablas) y se transcribe abajo en bloques ```kotlin```.

---

[IMAGEN — Portada del informe]
Portada institucional de TECSUP. Fondo blanco con formas geométricas abstractas en naranja, morado y azul en el lado derecho. Arriba a la izquierda el logo "Tecsup — Tecnología con sentido". Título grande: "INFORME DE LABORATORIO". Al centro-derecha, la mascota de Android (el robot verde) sosteniendo/mostrando el logo de Kotlin (triángulo naranja-morado-azul) sobre el pecho, junto a triángulos decorativos de colores. Debajo, en azul: "PROGRAMACIÓN EN MÓVILES". Luego los datos: "Docente: Benjamin Pareja", "Programa: Diseño y Desarrollo de Software", "2025 - Sur".

[IMAGEN — Logo "Android Developers"]
Logo del robot de Android (verde) junto al texto "Developers" en gris, correspondiente al branding de la documentación oficial de Android Developers. Aparece como imagen decorativa cerca del inicio del documento (sección de Objetivo/Equipos y materiales).

---

| Alumno(s): | | Nota | |
|---|---|---|---|
| Grupo: | | Ciclo: | |

| Criterio de Evaluación | Excelente (4pts) | Bueno (3pts) | Requiere mejora (2pts) | No acept. (0pts) | Puntaje Logrado |
|---|---|---|---|---|---|
| Desarrolla los ejercicios de git (parte 0) | | | | | **6** |
| Desarrolla los ejercicios (parte 1, 2 y 3) | | | | | **4** |
| Desarrolla el ejercicio (parte 4) | | | | | **5** |
| Realiza observaciones y conclusiones que aporten una opinión crítica y técnica | | | | | **3** |
| Es puntual y redacta el informe adecuadamente sin copias de otros autores | | | | | **2** |

## Laboratorio 04: Estados en Android

### I. Objetivo
- Uso de Git
- Introducción al Estado en Jetpack Compose
- Gestión del Estado en Jetpack Compose
- Principios básicos del Estado en Jetpack Compose

### II. Seguridad
- No ingresar con líquidos, ni comida al aula de Laboratorio.
- Al culminar la sesión de laboratorio apagar correctamente la computadora y la pantalla, y ordenar las sillas utilizadas.

### III. Equipos y Materiales
- Sistema Operativo Windows 10 o superior con conexión a la red del laboratorio.
- Android Studio o algún otro entorno de desarrollo donde se pueda correr aplicaciones móviles basadas en Kotlin y Jetpack Compose.

---

## DESARROLLO

### Parte 0: Profundización del uso de GIT

Realizaremos la creación de un repositorio de un proyecto android.

*(Para todos estos pasos, no será necesario la compilación de gradle, por lo que no deberíamos detenernos a esperar que compile nuestro proyecto)*

#### Paso 1: Creación de un repositorio

Realiza la inicialización de un repositorio "lab04" en tu ordenador. Documenta el proceso aquí. Vincula tu repositorio con GitHub en un repositorio en la nube público.

Enlaces de referencia:
- Documentación de GIT: https://git-scm.com/docs/git-init
- Documentación de Github: https://docs.github.com/es/repositories/creating-and-managing-repositories/quickstart-for-repositories
- Documentación de vinculación: https://kbroman.org/github_tutorial/pages/init.html

`[Espacio en blanco para que el alumno documente el proceso]`

#### Paso 2: Añadir .gitignore

Añade un archivo .gitignore de android al repositorio.

Enlaces de referencia:
- Cómo hacerlo en el repositorio: https://stackoverflow.com/questions/36732119/how-to-setup-gitignore-for-windows
- Información adicional: https://medium.com/@dilhancodes/how-to-adding-a-gitignore-file-to-your-git-repository-ce4b426af0a2
- Lista de archivos .gitignore: https://github.com/github/gitignore

`[Espacio en blanco para que el alumno documente el proceso]`

#### Paso 3: Ejecuta tu primer commit

En el repositorio creado anteriormente, crea un nuevo proyecto android, y sube un commit añadiendo los archivos base del proyecto (recuerda hacer funcionar correctamente el .gitignore). Súbelo a tu repositorio remoto.

[IMAGEN — Captura de pantalla de GitHub]
Captura de la interfaz web de GitHub mostrando el detalle de un commit. Encabezado gris claro con el texto "Initial commit" y debajo el ícono de rama con la etiqueta "main". Debajo, en una fila blanca, el texto "BparejaTec committed now" (nombre de usuario en negrita). Más abajo, un ícono de "colapsar/expandir diff" (flecha dentro de corchetes) seguido del texto "Showing 50 changed files with 1,513 additions and 0 deletions." (en negrita los números: 50 changed files, 1,513 additions, 0 deletions). Es decir, muestra el resultado real del primer commit subido por el alumno (usuario "BparejaTec"), confirmando que se agregaron 50 archivos con 1,513 líneas añadidas y ninguna eliminada.

El resultado debe ser añadir no más de 50 archivos al repositorio (aproximadamente).

Enlaces de referencia:
- Documentación de GIT: https://www.freecodecamp.org/espanol/news/el-comando-git-commit-explicado/
- Documentación de Github Desktop: https://docs.github.com/en/desktop/making-changes-in-a-branch/committing-and-reviewing-changes-to-your-project-in-github-desktop

`[Espacio en blanco para que el alumno documente el proceso]`

Añade 3 commits adicionales, que cada commit contenga la adición de un componente hecho el laboratorio pasado, sigue la documentación puesta a continuación.

[IMAGEN — Cuadro de referencia de componentes de Jetpack Compose]
Tabla/cuadro de tres columnas a modo de "cheat sheet", con fondo blanco y bordes finos grises, títulos en rojo oscuro y viñetas negras:
- **Columna 1 — "Contenedores":** Lazy Column, LazyRow, Grid, ConstraintLayout, Scaffold, Surface, Chip, BackdropScaffold, FlowRow, FlowColumn.
- **Columna 2 — "Controles":** AlertDialog, Card, Checkbox, FloatingActionButton, Icon, Image, ProgressBar, RadioButton, Slider, Spacer, Switch, TopAppBar.
- **Columna 3 — "Controles" (continuación):** BottomNavigation, Dialog, Divider, DropDownMenu, LazyVerticalGrid, NavigationRail, OutlinedTextField, Pager, Snackbar, TabRow, Tooltip.
(Es un listado de nombres de componentes/contenedores de Jetpack Compose a modo de referencia rápida; no contiene código.)

Enlace de referencia:
- Buenas prácticas para escribir commits en Git: https://midu.dev/buenas-practicas-escribir-commits-git/

`[Espacio en blanco para que el alumno documente el proceso]`

#### Paso 4: Revierte tu código

Copia y pega el código a tu proyecto, crea un nuevo commit con los cambios llamado "feat: Add ViewHolaCurso" y súbelo a tu repositorio.

```kotlin
fun ViewHolaCurso() {
    Column(
        modifier = Modifier
            .fillMaxWith()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to the Course!",
            fontSize = 28.sp,
            fontWeight = FontWeigh.Bold
        )
        Spacer(modifier = Modifier.heigh(16.dp))
        Text(
            text = "Hello, Student!",
            fontSize = 20.xD
        )
    }
}
```
> Nota: este bloque de código contiene errores intencionales tal como aparece en el documento original (no se corrigieron), ya que el ejercicio consiste en subir este código con errores y luego revertir el commit. Errores presentes: `fillMaxWith()` (debería ser `fillMaxWidth()`), `FontWeigh.Bold` (debería ser `FontWeight.Bold`), `Modifier.heigh(16.dp)` (debería ser `Modifier.height(16.dp)`), `fontSize = 20.xD` (sintaxis inválida, probablemente debía ser `20.sp`), y falta cerrar correctamente el segundo `Text(...)` antes de los cierres finales.

Si revisamos en Android Studio, el último código subido al repositorio presenta errores, entonces procederemos a borrar el commit.

Podríamos resolver los errores subiendo un nuevo commit con los cambios y correcciones del código, pero lo haremos eliminando el último commit realizado.

Enlaces de referencia:
- Documentación para borrar commits con git: https://stackoverflow.com/questions/1338728/how-do-i-delete-a-commit-from-a-branch
- Documentación para borrar commits github studio: https://docs.github.com/en/desktop/managing-commits/reverting-a-commit-in-github-desktop

`[Espacio en blanco para que el alumno documente el proceso]`

---

### Parte 1: Configuración Inicial del Proyecto

#### Paso 1: Crear un nuevo proyecto en Android Studio
- Abre Android Studio y selecciona la opción para crear un nuevo proyecto.
- **Nombre del Proyecto:** "MovieCounter".
- **Lenguaje:** Kotlin.
- **Tipo de Proyecto:** Selecciona "Empty Compose Activity". Esto configurará automáticamente tu proyecto para utilizar Jetpack Compose.

#### Paso 2: Verificación de la Configuración
- Una vez creado el proyecto, verifica que las dependencias de Jetpack Compose estén correctamente configuradas en el archivo build.gradle (Módulo: app). Si usaste la plantilla "Empty Compose Activity", debería estar todo listo para comenzar.

### Parte 2: Creación de la Interfaz Básica

#### Paso 1: Crear un Contador de Películas Simple

Comenzaremos creando una función de componibilidad llamada MovieCounter que mostrará el número de películas que el usuario ha agregado. Al principio, este número será estático.

```kotlin
@Composable
fun MovieCounter(modifier: Modifier = Modifier) {
    val count = 0
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have added $count movies.")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Acción del botón */ }) {
            Text("Add Movie")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieCounter() {
    MovieCounter()
}
```

**Explicación del Código:**
- **Text**: Muestra el número de películas agregadas.
- **Button**: Un botón que, por ahora, no realiza ninguna acción.

Implementa este código en tu proyecto y observa cómo se presenta el contador de películas en la pantalla.

`[Espacio en blanco para que el alumno documente el proceso]`

#### Paso 2: Introducir el Estado con remember

Ahora haremos que el número de películas sea dinámico utilizando remember para recordar cuántas películas han sido agregadas.

```kotlin
@Composable
fun MovieCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have added $count movies.")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { count++ }) {
            Text("Add Movie")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieCounter() {
    MovieCounter()
}
```

**Explicación del Código:**
- **remember**: Se utiliza para recordar el valor del estado `count` a través de recomposiciones.
- **mutableStateOf**: Crea un estado mutable que puede ser observado por Jetpack Compose.
- **Button(onClick = { count++ })**: Incrementa el contador cada vez que se presiona el botón.

Implementa este código y verifica que el contador de películas aumenta al hacer clic en el botón.

`[Espacio en blanco para que el alumno documente el proceso]`

#### Paso 3: Añadir un Campo de Texto para Ingresar el Nombre de la Película

A continuación, agregaremos un campo de texto donde el usuario pueda escribir el nombre de la película que desea agregar. Aunque no almacenaremos la película en una lista aún, esta funcionalidad permite al usuario interactuar con la aplicación.

```kotlin
@Composable
fun MovieCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    var movieName by remember { mutableStateOf("") }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have added $count movies.")
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = movieName,
            onValueChange = { movieName = it },
            label = { Text("Movie Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (movieName.isNotBlank()) {
                count++
                movieName = ""
            }
        }) {
            Text("Add Movie")
        }
    }
}
```

**Explicación del Código:**
- **TextField**: Permite al usuario escribir el nombre de la película.
- **movieName**: Variable de estado que mantiene el nombre de la película que se está escribiendo.
- **Button(onClick = { ... })**: Incrementa el contador y limpia el campo de texto si el nombre de la película no está vacío.

Implementa este código y verifica que puedes escribir un nombre de película y agregarlo, incrementando el contador.

`[Espacio en blanco para que el alumno documente el proceso]`

### Parte 3: Gestión del Estado y Persistencia

#### Paso 1: Uso de rememberSaveable para la Persistencia de Estado

Finalmente, vamos a hacer que el estado del contador y el nombre de la película persistan a través de cambios de configuración, como la rotación de la pantalla, utilizando rememberSaveable.

```kotlin
@Composable
fun MovieCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    var movieName by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have added $count movies.")
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = movieName,
            onValueChange = { movieName = it },
            label = { Text("Movie Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (movieName.isNotBlank()) {
                count++
                movieName = ""
            }
        }) {
            Text("Add Movie")
        }
    }
}
```

**Explicación del Código:**
- **rememberSaveable**: Similar a remember, pero permite que el estado se mantenga durante cambios de configuración como la rotación de la pantalla.

Implementa este código y verifica que el estado persiste cuando rotas la pantalla.

`[Espacio en blanco para que el alumno documente el proceso]`

---

### Puntos adicionales

Desarrolla el módulo "Estados en Jetpack Compose" y comparte la solución aquí (3 ptos).
Enlace: https://developer.android.com/codelabs/jetpack-compose-state?hl=es-419#0

`[Espacio en blanco para que el alumno documente el proceso]`

---

**OBSERVACIONES (5 mínimo):**
*(Las observaciones son las notas aclaratorias, objeciones y problemas que se pudo presentar en el desarrollo del laboratorio)*

`[Espacio en blanco para que el alumno complete]`

**CONCLUSIONES (5 mínimo):**
*(Las conclusiones son una opinión personal sobre tu trabajo, explicar cómo resolviste las dudas o problemas presentados en el laboratorio. Además de aportar una opinión crítica de lo realizado)*

`[Espacio en blanco para que el alumno complete]`

---
[Nota: el documento incluye además, en el encabezado/pie de página repetido en cada página, el logo institucional "Tecsup — Tecnología con sentido" en azul, sin contenido adicional relevante.]
