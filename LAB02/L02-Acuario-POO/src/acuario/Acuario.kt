package acuario

import kotlin.div
import kotlin.text.toInt

class Acuario(var largo: Int = 100, var ancho: Int = 20, var alto: Int = 40) {

    constructor(numeroDePeces: Int): this(){
        val tanque = numeroDePeces * 2000 * 1.1
        alto = (tanque / (largo * ancho)).toInt()
    }

    fun imprimirTamano() {
        println("Tamaño -> Ancho: $ancho cm " + "Largo: $largo cm" + "alto: $alto cm")
    }
    init {
        println("Iniciando acuario")
    }
    init {
        // i litro = 1000 cm3
        println("Volumen: ${ancho*largo*alto/1000}l")
    }
}