package acuario

abstract class Pez {
    abstract val color: String
}

class Tiburon : Pez() {
    override val color = "gris"
}

class PezPayaso : Pez() {
    override val color = "dorado"
}
