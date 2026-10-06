# Speech rápido: La novia celosa

**[Empieza con voz de notificación: “¡Prrr! ¡Prrr! ¡Prrr!”]**

—¿Dónde estás? ¿Con quién? ¿Por qué no contestas?

¡Tranquilos! No es una emergencia: es nuestra app de **La Novia Celosa**. Tocamos **Iniciar notificaciones** y el teléfono recibe diez mensajes reales, uno cada dos segundos. Si queremos repetir el drama, pulsamos **Reiniciar notificaciones**.

Ahora activamos el modo oscuro y silenciamos los mensajes: DataStore guarda esas preferencias y cancela las notificaciones que faltan. Usamos Preferences DataStore porque son valores sencillos. Cerramos y volvemos a abrir: ¿recordará lo que elegimos? **¡Sí!**

DataStore es la alternativa moderna a SharedPreferences: trabaja de forma asíncrona y sus cambios son transaccionales. Para datos con estructura definida existe Proto DataStore; para listas grandes y consultas, Room. ¡DataStore tiene buena memoria… ojalá también supiera cuándo dejar de escribir nuestra novia!

## Demostración en vivo

1. Abre la app, toca **Iniciar notificaciones** y acepta el permiso de Android si aparece.
2. Mantén el menú abierto mientras llegan los mensajes; desliza desde arriba para mostrar la bandeja.
3. Activa **Silenciar mensajes** para detenerlos y prueba **Reiniciar notificaciones** cuando quieras repetir la secuencia.
4. Cambia el modo oscuro y vuelve a abrir la app para mostrar que DataStore conservó las preferencias.

## Reparto sugerido para 4 personas

1. Presenta el problema con el speech y explica SharedPreferences.
2. Demuestra los interruptores y explica DataStore.
3. Explica Preferences DataStore vs Proto DataStore.
4. Explica Room, archivos y nube; cierra con la prueba de persistencia.
