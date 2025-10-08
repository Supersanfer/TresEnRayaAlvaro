package com.dam2.tresenrayaalvaro

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.dam2.tresenrayaalvaro.databinding.ActivityJuegoBinding

class Juego : AppCompatActivity() {
    private lateinit var binding: ActivityJuegoBinding
    private var contadorRondas = 1;
    private lateinit var nombreJugadorUno: String
    private lateinit var nombreJugadorDos: String
    private lateinit var arrayTablero: Array<Array<ImageButton>>
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
    }

    private fun setearContador(nombreJugador:String) {
        binding.tvTurnoJugador.text = "Turno de $nombreJugador"
    }

    fun onClicked(vista: View) {

        val posicionPulsada = (vista as ImageButton).tag.toString()
        if (contadorRondas % 2 != 0) {
            setearContador(nombreJugadorUno)
            gestionarBoton(posicionPulsada, R.drawable.equis)
        } else {
            setearContador(nombreJugadorDos)
            gestionarBoton(posicionPulsada, R.drawable.circulo)
        }

        contadorRondas += 1
    }

    private fun gestionarBoton(posicionPulsada: String, img: Int) {
        /*
        when (posicionPulsada) {
            "ib00" -> binding.ib00.setImageResource(img)
            "ib01" -> binding.ib01.setImageResource(img)
            "ib02" -> binding.ib02.setImageResource(img)
            "ib10" -> binding.ib10.setImageResource(img)
            "ib11" -> binding.ib11.setImageResource(img)
            "ib12" -> binding.ib12.setImageResource(img)
            "ib20" -> binding.ib20.setImageResource(img)
            "ib21" -> binding.ib21.setImageResource(img)
            "ib22" -> binding.ib22.setImageResource(img)
        }
        */
        for (i in arrayTablero.indices) {
            for (j in arrayTablero[i].indices) {
                if (arrayTablero[i][j].tag == posicionPulsada) {
                    arrayTablero[i][j].setImageResource(img)
                    return
                }
            }
        }
    }

}

