package acuario

import kotlin.div
import kotlin.text.toInt

class Acuario(var largo: Int = 100, var ancho: Int = 20, var alto: Int = 40) {

    var volumen: Int
        get() = ancho * alto * largo / 1000
        set(valor) {
            alto = (valor * 1000) / (ancho * largo)
        }

    constructor(numeroDePeces: Int): this(){
        val tanque = numeroDePeces * 2000 * 1.1
        alto = (tanque / (largo * ancho)).toInt()
    }

    fun imprimirTamano() {
        println("Tamaño -> Ancho: $ancho cm " + "Largo: $largo cm" + "alto: $alto cm")
        println("Volumen: $volumen l")
    }
    init {
        println("Iniciando acuario")
    }
}