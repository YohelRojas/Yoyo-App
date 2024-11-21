package cr.ac.utn.com.example.yoyoapp.entities

import java.util.Date
import java.util.UUID

data class Factura(
    val id: String = UUID.randomUUID().toString(),
    val numero: String,
    val cliente: String,
    val productos: String,
    var total: Double,
    val fecha: String = Date().toString()
)
