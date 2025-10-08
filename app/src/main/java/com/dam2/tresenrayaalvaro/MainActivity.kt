package com.dam2.tresenrayaalvaro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dam2.tresenrayaalvaro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onBtnEmpezarJuego_clicked(vista: View){
        val intent  = Intent(this, Juego::class.java)
        val nombre1 = binding.etNombreJugador1.text.toString()
        val nombreJugador1 = nombre1.ifEmpty { "Jugador 1" }
        val nombre2 = binding.etNombreJugador2.text.toString()
        val nombreJugador2 = nombre2.ifEmpty { "Jugador 2" }
        intent.putExtra("nombreJugadorUno", nombreJugador1)
        intent.putExtra("nombreJugadorDos", nombreJugador2)
        startActivity(intent)
    }

}