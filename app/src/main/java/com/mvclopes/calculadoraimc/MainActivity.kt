package com.mvclopes.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mvclopes.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // Configurando evento de clique no botão de calcular
        binding.btnMakeCalc.setOnClickListener {
            // Obtenção dos valores inseridos (peso e altura) pelo usuário
            val pesoTxt = binding.edtPeso.text.toString()
            val alturaTxt = binding.edtAltura.text.toString()

            // Chamada ao método que calcula IMC
            val imcResult = getImcResult(pesoTxt, alturaTxt)

            // Exibição do resultado
            binding.txtResultImc.text = imcResult.result.label
        }
    }
}