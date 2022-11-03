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

            val imcResult = getImcResult(pesoTxt, alturaTxt)

            binding.txtResultImc.text = imcResult.result.label
        }
    }
}