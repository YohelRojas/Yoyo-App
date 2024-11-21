package cr.ac.utn.com.example.yoyoapp.entities

import android.graphics.Bitmap
import java.io.Serializable

data class Producto(
    val id: String,
    val nombre: String,
    val precio: Double,
    val cantidad: Int,
    var imagenBitmap: Bitmap? = null
) : Serializable
