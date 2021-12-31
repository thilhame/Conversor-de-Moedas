package com.example.conversodedinheiro

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.conversodedinheiro.databinding.InicialBinding
import com.example.conversodedinheiro.ui.main.MainActivity


class TelaInicio:AppCompatActivity() {

    private val binding by lazy { InicialBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        chamarTelaInicial()

    }

    private fun chamarTelaInicial() {
        binding.btinicio.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}