package ejemplopropio

abstract class Vehiculo(val marca: String, open var velocidad: Int = 0) {
    abstract val tipo: String
}

interface AccionVehiculo {
    fun acelerar()
    fun frenar()
}

open class Auto(marca: String, val puertas: Int) : Vehiculo(marca), AccionVehiculo {
    override val tipo = "automovil"

    open var capacidadMaletera: Int = 400
        get() = field
        set(valor) { field = if (valor > 0) valor else 0 }

    override fun acelerar() {
        velocidad += 20
        println("$marca aceleró. Velocidad: $velocidad km/h")
    }

    override fun frenar() {
        velocidad = 0
        println("$marca frenó.")
    }
}

class Camioneta(marca: String, puertas: Int, override var capacidadMaletera: Int) : Auto(marca, puertas) {
    override val tipo = "camioneta"
}

class Moto(marca: String) : Vehiculo(marca), AccionVehiculo {
    override val tipo = "motocicleta"

    override fun acelerar() {
        velocidad += 30
        println("$marca aceleró rápido. Velocidad: $velocidad km/h")
    }

    override fun frenar() {
        velocidad = 0
        println("$marca frenó con el freno de disco.")
    }
}

class Garaje(var capacidad: Int = 2) {
    private val vehiculos = mutableListOf<Vehiculo>()

    init {
        println("Garaje inaugurado con capacidad para $capacidad vehículos")
    }

    constructor(listaVehiculos: List<Vehiculo>) : this(listaVehiculos.size) {
        vehiculos.addAll(listaVehiculos)
        println("Garaje creado con ${vehiculos.size} vehículos preexistentes")
    }

    fun estacionar(vehiculo: Vehiculo): Boolean {
        if (vehiculos.size >= capacidad) {
            println("Garaje lleno, no cabe ${vehiculo.marca}")
            return false
        }
        vehiculos.add(vehiculo)
        println("${vehiculo.marca} estacionado. Espacios usados: ${vehiculos.size}/${capacidad}")
        return true
    }

    fun listar() {
        println("Vehículos en el garaje:")
        vehiculos.forEach { println("- ${it.marca} (${it.tipo})") }
    }
}
