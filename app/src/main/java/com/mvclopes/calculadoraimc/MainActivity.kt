package com.mvclopes.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mvclopes.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnMakeCalc.setOnClickListener {
            val pesoTxt = binding.edtPeso.text.toString()
            val alturaTxt = binding.edtAltura.text.toString()
            val peso = pesoTxt.toFloat()
            val altura = alturaTxt.toFloat()
            val imc = peso / (altura * altura)
            if (imc < 16){
                binding.txtResultImc.text = "Magreza grave"
            } else if (imc < 17){
                binding.txtResultImc.text = "Magreza moderada"
            } else if (imc < 18.5){
                binding.txtResultImc.text = "Magreza leve"
            } else if (imc < 25){
                binding.txtResultImc.text = "Saudável"
            } else if (imc < 30){
                binding.txtResultImc.text = "Sobrepeso"
            } else if (imc < 35){
                binding.txtResultImc.text = "Obesidade Grau I"
            } else if (imc < 40){
                binding.txtResultImc.text = "Obesidade Grau II (severa)"
            } else {
                binding.txtResultImc.text = "Obesidade Grau III (mórbida)"
            }
        }
    }
}