# Tres en Raya (Tic-Tac-Toe)

Una implementación sencilla del clásico juego **Tres en Raya** (Tic-Tac-Toe) para dispositivos Android, desarrollado en Kotlin.

---

## Acerca del Proyecto

Este proyecto contiene la lógica principal para gestionar una partida entre dos jugadores. La clase `Juego.kt` es la actividad principal que maneja la alternancia de turnos y la interacción con el tablero.

### Características Clave Implementadas:

* **Juego de Dos Jugadores:** Permite el enfrentamiento 1 contra 1.
* **Gestión de Nombres:** Los nombres de los jugadores se pasan a la actividad a través de un `Intent`.
* **Alternancia de Turnos:** Utiliza la variable `contadorRondas` para determinar qué jugador juega (impar = Jugador 1, par = Jugador 2).
* **Tablero 3x3:** El tablero se gestiona mediante un **Array Bidimensional** (`arrayTablero`) de `ImageButton`.

---

## Tecnologías Utilizadas

* **Lenguaje:** Kotlin
* **Plataforma:** Android Studio
* **Patrón de Vista:** View Binding (`ActivityJuegoBinding`)

