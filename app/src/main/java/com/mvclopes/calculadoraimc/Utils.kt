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
    if (imc < 16){
        return IMCResult(Result.MAGREZA_III)
    } else if (imc < 17){
        return IMCResult(Result.MAGREZA_II)
    } else if (imc < 18.5){
        return IMCResult(Result.MAGREZA_I)
    } else if (imc < 25){
        return IMCResult(Result.OK)
    } else if (imc < 30){
        return IMCResult(Result.SOBREPESO)
    } else if (imc < 35){
        return IMCResult(Result.OBESIDADE_I)
    } else if (imc < 40){
        return IMCResult(Result.OBESIDADE_II)
    } else {
        return IMCResult(Result.OBESIDADE_III)
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