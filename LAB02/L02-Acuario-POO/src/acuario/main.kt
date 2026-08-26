package acuario

fun construirAcuario(){

    // creamos una instancia con valores predefinidos del constructor
    val acuario1 = Acuario()
    acuario1.imprimirTamano()

    // se crea una isntancia "acuario2" con el ancho 25 - Se puede observar que solo se usa un parametro del constructor
    val acuario2 = Acuario(ancho = 25)
    acuario2.imprimirTamano()

    // otra instancia "acuario3" con 2 parametros modificados, 2 atributos modificados
    val acuario3 = Acuario(alto = 35, largo = 110)
    acuario3.imprimirTamano()

    // todo personalizado
    val acuario4 = Acuario(ancho = 25, alto = 35, largo = 110)
    acuario4.imprimirTamano()
}

fun main() {
    construirAcuario()
}