package cr.ac.utn.com.example.yoyoapp.model

import cr.ac.utn.com.example.yoyoapp.entities.Producto

class ProductoModel {

    private val productos = mutableListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }

    fun obtenerProductos(): List<Producto> {
        return productos
    }
    fun obtenerProductos(id: String): Producto? {
        return productos.find { it.id == id }
    }
    fun eliminarProducto(id: String) {
        productos.removeAll { it.id == id }
    }
}
