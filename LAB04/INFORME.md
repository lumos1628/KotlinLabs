# Informe de Laboratorio 04

**Curso:** Programación en Móviles
**Laboratorio:** Estados en Android
**Docente:** Benjamin Pareja
**Programa:** Diseño y Desarrollo de Software
**Ciclo:** 2025 - Sur

---

## 1. Objetivo

- Profundizar en el uso de Git y GitHub para el control de versiones.
- Introducción al Estado en Jetpack Compose.
- Gestión del Estado en Jetpack Compose.
- Principios básicos del Estado en Jetpack Compose.

---

## 2. Desarrollo

### Parte 0: Profundización del uso de Git

Se creó la carpeta `LAB04/` dentro del repositorio `KotlinLabs` con el proyecto `MovieCounter`. Se documentó el proceso:

1. **Inicialización del repositorio y `.gitignore`**: se añadió el `.gitignore` de Android para evitar subir archivos de build y configuraciones locales.
2. **Primer commit**: se subieron los archivos base del proyecto.
3. **3 commits adicionales**: se añadió un componente del laboratorio anterior por commit (`Column`, `Row`, `Button`).
4. **Revertir código**: se subió el composable `ViewHolaCurso` con errores intencionales y se eliminó el último commit con `git revert HEAD`.

### Partes 1-3: App MovieCounter

1. **Configuración inicial**: proyecto `MovieCounter` con plantilla Empty Compose Activity; se verificaron las dependencias de Jetpack Compose.
2. **Contador estático**: `MovieCounter` con `val count = 0`, sin reaccionar al usuario.
3. **Estado dinámico**: se usó `remember { mutableStateOf(0) }` y `count++` en el botón.
4. **Campo de texto**: se agregó `TextField` con `state hoisting` y validación con `isNotBlank()`.
5. **Persistencia**: se reemplazó `remember` por `rememberSaveable` para sobrevivir a rotaciones de pantalla.

### Puntos adicionales: Módulo "Estados en Jetpack Compose"

Se creó el proyecto `LAB04-BasicState` con la app de bienestar, aplicando:

1. Lista con `LazyColumn`.
2. `Checkbox` con estado propio.
3. State hoisting (estado elevado a la lista).
4. `ViewModel` como dueño del estado.
5. Agregar y eliminar tareas.

---

## 3. Evidencias

Las capturas deben estar en `LAB04/capturas/`:

| Evidencia | Descripción |
|---|---|
| `01_commit_inicial.png` | Commit inicial del proyecto en GitHub. |
| `02_gitignore.png` | Adición del `.gitignore`. |
| `03_view_hola_curso.png` | Commit `feat: Add ViewHolaCurso` y su revert. |
| `04_moviecounter_estatico.png` | Contador estático (no cambia). |
| `05_moviecounter_dinamico.png` | Contador aumentando al presionar "Add Movie". |
| `06_moviecounter_textfield.png` | Campo de texto con nombre y contador subido. |
| `07_remember_saveable.png` | Estado persistente tras rotar la pantalla. |
| `08_basicstate_lista.png` | Lista de tareas con casillas marcadas, tarea agregada y eliminada. |

---

## 4. Observaciones

1. El `.gitignore` es fundamental para que archivos como `local.properties`, `.idea` y carpetas `build` no se suban al repositorio y ensucien el historial.
2. `git revert HEAD` crea un commit nuevo que deshace el anterior sin reescribir el historial; es más seguro que `git reset` cuando el repositorio ya fue compartido.
3. Con `remember`, el estado se pierde al rotar la pantalla porque la Activity se recrea; `rememberSaveable` lo conserva guardándolo en el Bundle.
4. En Compose, un `TextField` no se actualiza solo: necesita `value` y `onValueChange` (state hoisting), porque el estado vive en el padre.
5. La validación `isNotBlank()` evita contar películas sin nombre y mantiene la lógica de negocio separada de la interfaz.
6. El `ViewModel` sobrevive a cambios de configuración y centraliza la lógica, evitando que la UI maneje el estado directamente.
7. La plantilla generada por el CLI incluye archivos extra (navegación, ViewModel, tests) que no interfieren con el desarrollo del laboratorio.

---

## 5. Conclusiones

1. Git permitió organizar cada avance como un commit atómico, haciendo posible volver atrás cuando se subió código con errores.
2. Jetpack Compose funciona de forma declarativa: el estado determina lo que se dibuja, y al cambiar el estado, la UI se recompone.
3. `remember` y `mutableStateOf` son la base para crear interfaces interactivas en Compose.
4. `rememberSaveable` es esencial para mantener el estado ante rotaciones de pantalla, algo que `remember` por sí solo no logra.
5. El state hoisting mejora la reutilización: los componentes reciben su estado desde el padre en lugar de crearlo internamente.
6. El patrón ViewModel separa la lógica de negocio de la UI, lo que hace la app más mantenible y testeable.
7. El módulo adicional reforzó los conceptos del laboratorio aplicándolos a una app real (lista de tareas), integrando LazyColumn, checkbox, hoisting y ViewModel.

---

*Informe generado para el Laboratorio 04: Estados en Android.*