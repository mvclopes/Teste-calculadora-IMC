package com.mvclopes.calculadoraimc

import org.junit.Assert.*

import org.junit.Test

class UtilsKtTest {

    @Test
    fun `getImcResult deve retornar Sobrepeso quando peso 90 e altura 180`() {
        // Given
        val peso = "90"
        val altura = "1.80"

        // When
        val imcResult = getImcResult(peso, altura)

        // Then
        assertEquals(Result.SOBREPESO, imcResult.result)
    }

    @Test
    fun `getImcResult deve retornar Blank quando peso ou altura for vazio`() {
        // Given
        val peso = ""
        val altura = ""

        // When
        val imcResult = getImcResult(peso, altura)

        // Then
        assertEquals(Result.BLANK, imcResult.result)
    }
}