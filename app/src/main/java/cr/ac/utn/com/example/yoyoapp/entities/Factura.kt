package cr.ac.utn.com.example.yoyoapp.entities

data class Factura(
    val numero: String,
    val cliente: String,
    val productos: List<Producto>,
    val fecha: String,
    val total: Double
)
