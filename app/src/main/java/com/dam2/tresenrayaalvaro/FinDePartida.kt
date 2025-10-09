package com.dam2.tresenrayaalvaro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dam2.tresenrayaalvaro.databinding.ActivityFinDePartidaBinding

class FinDePartida : AppCompatActivity() {
    private lateinit var binding: ActivityFinDePartidaBinding
    private lateinit var mensajeAMostrar:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinDePartidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mensajeAMostrar = intent.getStringExtra("resultadoPartida").toString()
        if(mensajeAMostrar.lowercase() == "empate"){
            binding.tvMensajeFinPartida.text = "Partida sin ganador. EMPATE"
        }else{
            binding.tvMensajeFinPartida.text = "$mensajeAMostrar ha ganado"
        }
    }
    fun onClick(vista : View){
        finish()
    }
}