package com.dam2.tresenrayaalvaro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.dam2.tresenrayaalvaro.databinding.ActivityJuegoBinding

class Juego : AppCompatActivity() {
    private lateinit var binding: ActivityJuegoBinding
    private var contadorRondas = 0;
    private lateinit var nombreJugadorUno: String
    private lateinit var nombreJugadorDos: String
    private lateinit var arrayTablero: Array<Array<ImageButton>>
    private var arrayNumeros = Array(3){ IntArray(3) {0} }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJuegoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nombreJugadorUno = intent.getStringExtra("nombreJugadorUno") ?: "Jugador 1"
        nombreJugadorDos = intent.getStringExtra("nombreJugadorDos") ?: "Jugador 2"
        arrayTablero = arrayOf(
            arrayOf(binding.ib00, binding.ib01, binding.ib02),
            arrayOf(binding.ib10, binding.ib11, binding.ib12),
            arrayOf(binding.ib20, binding.ib21, binding.ib22)
        )
        setearContador(nombreJugadorUno)
    }

    private fun setearContador(nombreJugador:String) {
        binding.tvTurnoJugador.text = "Turno de $nombreJugador"
    }

    fun onClicked(vista: View) {
        val botonPulsado = (vista as ImageButton)
        botonPulsado.isEnabled = false

        val jugadorActual: Int
        val nombreProximoJugador: String
        val recursoImagen: Int

        // Determinamos el jugador actual (1 o 2)
        if (contadorRondas % 2 == 0) {
            jugadorActual = 1
            recursoImagen = R.drawable.equis
            nombreProximoJugador = nombreJugadorDos
        } else {
            jugadorActual = 2
            recursoImagen = R.drawable.circulo
            nombreProximoJugador = nombreJugadorUno
        }

        val posicionPulsada = botonPulsado.tag.toString()
        asignarValorEImagen(jugadorActual, posicionPulsada, recursoImagen)

        contadorRondas += 1

        if (hayGanador()) {
            val nombreGanador: String
            if (jugadorActual == 1) {
                nombreGanador = nombreJugadorUno
            } else {
                nombreGanador = nombreJugadorDos
            }
            mandarNombreAVentanaFinDePartida(nombreGanador)
            finish()
        } else if (contadorRondas == 9) {
            mandarNombreAVentanaFinDePartida("empate")
            finish()
        } else {
            setearContador(nombreProximoJugador)
        }
    }

    private fun mandarNombreAVentanaFinDePartida(resultado: String) {
        val intent  = Intent(this, FinDePartida::class.java)
        intent.putExtra("resultadoPartida", resultado)
        startActivity(intent)
    }

    private fun hayGanador(): Boolean {
        var hayGanador = false;

        for(i in 0 until 3){
            // Comprobamos horizontales
            if(arrayNumeros[i][0]!=0
                && arrayNumeros[i][0] == arrayNumeros[i][1]
                && arrayNumeros[i][0] == arrayNumeros[i][2]){
                hayGanador = true;
            }
            // Comprobamos verticales
            if(arrayNumeros[0][i]!=0
                && arrayNumeros[0][i] == arrayNumeros[1][i]
                && arrayNumeros[0][i] == arrayNumeros[2][i]){
                hayGanador = true
            }
        }
        // Comprobamos diagonales
        if((arrayNumeros[0][0] != 0
                    && arrayNumeros[0][0] == arrayNumeros[1][1]
                    && arrayNumeros[0][0] == arrayNumeros[2][2])
            ||
            (arrayNumeros[0][2] !=0
                    && arrayNumeros[0][2] == arrayNumeros[1][1]
                    && arrayNumeros[0][2] == arrayNumeros[2][0])) {
            hayGanador = true
        }
        return hayGanador;
    }

    private fun asignarValorEImagen(jugadorActual: Int, posicionPulsada: String, img: Int) {
        for (i in arrayTablero.indices) {
            for (j in arrayTablero[i].indices) {
                if (arrayTablero[i][j].tag.toString() == posicionPulsada) {
                    arrayTablero[i][j].setImageResource(img)
                    arrayNumeros[i][j] = jugadorActual
                    return
                }
            }
        }
    }
}