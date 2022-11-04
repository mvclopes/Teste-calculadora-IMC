package com.mvclopes.calculadoraimc

import org.junit.Assert.*

import org.junit.Test

class UtilsKtTest {

    @Test
    fun `getImcResult deve retornar Sobrepeso quando peso 90 e altura 180`() {
        // Given: fornecendo valores de parâmetros ao método a ser testado
        val peso = "90"
        val altura = "1.80"

        // When: chamada ao método a ser testado
        val imcResult = getImcResult(peso, altura)

        // Then: Verificação do valor esperado pelo obtido
        assertEquals(Result.SOBREPESO, imcResult.result)
    }

    @Test
    fun `getImcResult deve retornar Blank quando peso ou altura for vazio`() {
        // Given: fornecendo valores de parâmetros ao método a ser testado
        val peso = ""
        val altura = ""

        // When: chamada ao método a ser testado
        val imcResult = getImcResult(peso, altura)

        // Then: Verificação do valor esperado pelo obtido
        assertEquals(Result.BLANK, imcResult.result)
    }
}