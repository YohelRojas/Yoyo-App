package cr.ac.utn.com.example.yoyoapp.entities

import java.io.Serializable

data class Producto(
    val id: String,
    val nombre: String,
    val precio: Double,
    val cantidad: Int,
    val imagenUri: String?
) : Serializable
