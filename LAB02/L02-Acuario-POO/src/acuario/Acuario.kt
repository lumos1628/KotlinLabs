package acuario

class Acuario(largo: Int =100, ancho: Int = 20, alto: Int = 40) {
    var ancho:Int = largo
    var alto:Int = ancho
    var largo:Int = alto

    fun imprimirTamano() {
        println("Ancho: $ancho cm " + "Largo: $largo cm" + "alto: $alto cm")
    }
}