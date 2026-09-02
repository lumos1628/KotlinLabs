package ejemplopropio

fun main() {
    val auto = Auto("Toyota", 4)
    auto.acelerar()
    auto.frenar()
    auto.capacidadMaletera = 500
    println("Capacidad maletera: ${auto.capacidadMaletera} litros")

    val moto = Moto("Yamaha")
    moto.acelerar()
    moto.frenar()

    val camioneta = Camioneta("Ford", 4, 800)
    camioneta.acelerar()
    println("Tipo: ${camioneta.tipo}, capacidad maletera: ${camioneta.capacidadMaletera}")

    val garaje = Garaje(listOf(auto, moto))
    garaje.estacionar(camioneta)
    garaje.listar()

    val garaje2 = Garaje(5)
    garaje2.estacionar(camioneta)
    garaje2.listar()
}
