package com.mvclopes.calculadoraimc

/**
 * Método responsável por calcular IMC do usuário baseado em seu peso e altura
 * @param pesoTxt [String] peso do usuário
 * @param alturaTxt [String] altura do usuário
 * @return [IMCResult] IMC do usuário
 */
internal fun getImcResult(pesoTxt: String, alturaTxt: String): IMCResult {
    if (!entradaValida(pesoTxt, alturaTxt))
        return IMCResult(Result.BLANK)

    val peso = pesoTxt.toFloat()
    val altura = alturaTxt.toFloat()
    val imc = peso / (altura * altura)

    return when {
        imc < 16 -> IMCResult(Result.MAGREZA_III)
        imc in 16f..16.9f -> IMCResult(Result.MAGREZA_II)
        imc in 17f..18.49f -> IMCResult(Result.MAGREZA_I)
        imc in 18.5f..24.9f -> IMCResult(Result.OK)
        imc in 25f..29.9f -> IMCResult(Result.SOBREPESO)
        imc in 30f..34.9f -> IMCResult(Result.OBESIDADE_I)
        imc in 35f..39.9f -> IMCResult(Result.OBESIDADE_II)
        else -> IMCResult(Result.OBESIDADE_III)
    }
}

/**
 * Método responsável por verificar se entrada fornecida é válida
 * @param peso [String]
 * @param altura [String]
 * @return [Boolean]
 */
private fun entradaValida(peso: String, altura: String): Boolean {
    return !(peso.isEmpty() || altura.isEmpty())
}

data class IMCResult(val result: Result)
enum class Result(val label: String) {
    MAGREZA_III("Magreza Severa"),
    MAGREZA_II("Magreza moderada"),
    MAGREZA_I("Magreza leve"),
    OK("Saudável"),
    SOBREPESO("Sobrepeso"),
    OBESIDADE_I("Obesidade Grau I"),
    OBESIDADE_II("Obesidade GHrau II (severa)"),
    OBESIDADE_III("Obesidade GHrau III (mórbida)"),
    BLANK("Insira os valores de peso e altura corretamente")
}