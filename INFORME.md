# Informe de Laboratorio 03

**Curso:** Desarrollo de Aplicaciones Móviles  
**Laboratorio:** Aplicar Layouts en Android  
**Tema:** Jetpack Compose, Column, Row, componentes básicos y layouts

---

## 1. Objetivo

Introducir el desarrollo de interfaces de usuario en Android utilizando Jetpack Compose, comprendiendo la estructura de un proyecto, los elementos componibles básicos y la organización de layouts con `Column` y `Row`.

---

## 2. Desarrollo

### 2.1 Proyecto principal: `LAB03` (Bienvenido Al Curso)

Se desarrolló una aplicación que muestra una tarjeta de bienvenida con los siguientes pasos:

1. **Tarjeta básica:** `Column`, `Text` y `Spacer`.
2. **Tarjeta con entrada e imagen:** se añadieron `TextField` e `Image`.
3. **Tarjeta con botón personalizado:** se añadió un `Button` con color, esquinas redondeadas y texto personalizado.
4. **Tarjeta final:** se organizaron los botones **Aceptar** y **Rechazar** dentro de un `Row` usando `Arrangement.SpaceAround`.

### 2.2 Ejercicio: recrear la vista

Se implementó la función `TarjetaPresentacion()`, que incluye imagen, título, campo de texto, botones de acción y un saludo personalizado que responde al estado.

### 2.3 Proyecto de exploración de componentes: `LAB03-Componentes`

Se creó un proyecto adicional con una función `@Composable` y su `@Preview` para cada uno de los siguientes elementos:

- `Column`
- `Row`
- `Box`
- `Text`
- `Button`
- `TextField`
- `Image`
- `Spacer`
- `Card`

Cada componente incluye una breve descripción de sus atributos clave.

### 2.4 Módulo adicional: `LAB03-BasicosCompose`

Se desarrolló el módulo "Conceptos básicos de Compose" con los siguientes ejercicios:

1. Hola Mundo con Compose.
2. Contador con estado.
3. Saludo personalizado con `TextField`.
4. Lista simple con `Column`.
5. Tarjeta con imagen.
6. Uso básico de `Modifier`.

---

## 3. Evidencias

### Proyecto principal `LAB03`

![Paso 1 - Greeting Card Básica](LAB03/capturas/01_greeting_card_basica.png)

![Paso 2 - Input e Image](LAB03/capturas/02_greeting_card_input_image.png)

![Paso 3 - Con Botón Personalizado](LAB03/capturas/03_greeting_card_boton.png)

![Paso 4 - Final con Row](LAB03/capturas/04_greeting_card_final.png)

![App ejecutada](LAB03/capturas/05_app_ejecutada.png)

![Ejercicio - Tarjeta de Presentación](LAB03/capturas/06_ejercicio_vista.png)

### Proyecto `LAB03-Componentes`

![Demo Column](LAB03-Componentes/capturas/07_componente_column.png)

![Demo Row](LAB03-Componentes/capturas/08_componente_row.png)

![Demo Box](LAB03-Componentes/capturas/09_componente_box.png)

![Demo Text](LAB03-Componentes/capturas/10_componente_text.png)

![Demo Button](LAB03-Componentes/capturas/11_componente_button.png)

![Demo TextField](LAB03-Componentes/capturas/12_componente_textfield.png)

![Demo Image](LAB03-Componentes/capturas/13_componente_image.png)

![Demo Spacer](LAB03-Componentes/capturas/14_componente_spacer.png)

![Demo Card](LAB03-Componentes/capturas/15_componente_card.png)

![Vista General](LAB03-Componentes/capturas/16_componentes_general.png)

### Proyecto `LAB03-BasicosCompose`

![Conceptos Básicos de Compose](LAB03-BasicosCompose/capturas/17_basicos_compose.png)

---

## 4. Observaciones

1. El proyecto `LAB03` ya estaba creado con la estructura base de Empty Activity, por lo que solo fue necesario implementar el contenido del laboratorio.
2. La versión del plugin de Compose del template generado por `android create empty-activity` varía según la versión del CLI; el proyecto principal usa `kotlin.compose` mientras que los nuevos proyectos usan `compose.compiler`.
3. El uso de `remember` y `mutableStateOf` es fundamental para que los componentes como `TextField` y `Button` respondan a las interacciones del usuario.
4. `Arrangement.SpaceAround` distribuye los elementos de un `Row` dejando espacio igual a los lados, lo cual mejora la estética de los botones.
5. Los `Preview` permiten visualizar los composables sin necesidad de ejecutar un emulador, acelerando el desarrollo y la depuración.
6. La personalización del tema (colores primarios, secundarios y de fondo) ayuda a mantener una identidad visual consistente en toda la app.
7. El recurso de imagen se implementó como un vector drawable (`ic_course.xml`) para evitar depender de archivos binarios externos.
8. En el proyecto de exploración de componentes se decidió conservar la estructura base generada por el template y crear un nuevo archivo de componentes para no romper dependencias.
9. El módulo adicional cubre los conceptos fundamentales de Compose: estado, recomposición, modifiers y listas simples.
10. La compilación mediante `./gradlew build` permite detectar errores de sintaxis y dependencias antes de probar la app en un dispositivo.

---

## 5. Conclusiones

1. Jetpack Compose simplifica la creación de interfaces en Android al utilizar un enfoque declarativo basado en funciones componibles.
2. `Column` y `Row` son contenedores esenciales para organizar elementos en vertical y horizontal respectivamente.
3. El manejo del estado con `remember` y `mutableStateOf` es el pilar para crear interfaces interactivas en Compose.
4. Los `Modifier` permiten controlar tamaño, alineación, padding, fondo y forma de los componentes de manera flexible.
5. Separar la interfaz en composables pequeños y reutilizables mejora la legibilidad y mantenibilidad del código.
6. Los `@Preview` son una herramienta poderosa para iterar rápidamente sobre el diseño sin depender de un emulador.
7. La personalización del tema y los colores permite adaptar la app a los requerimientos visuales del laboratorio.
8. La exploración individual de componentes facilita comprender el propósito y los atributos de cada uno antes de combinarlos en una interfaz compleja.
9. El desarrollo del módulo adicional reforzó los conceptos básicos necesarios para continuar con laboratorios más avanzados.
10. La organización del trabajo en tres proyectos diferenciados (principal, componentes y conceptos básicos) facilita la evaluación y el seguimiento de cada parte del laboratorio.

---

## 6. Repositorios

- Proyecto principal: `LAB03/`
- Exploración de componentes: `LAB03-Componentes/`
- Conceptos básicos de Compose: `LAB03-BasicosCompose/`

---

*Informe generado para el Laboratorio 03 de Aplicar Layouts en Android.*
