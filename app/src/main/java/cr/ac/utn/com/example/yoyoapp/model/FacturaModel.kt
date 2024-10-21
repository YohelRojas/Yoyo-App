package cr.ac.utn.com.example.yoyoapp.model

import cr.ac.utn.com.example.yoyoapp.entities.Factura

class FacturaModel {
    private val facturas: MutableList<Factura> = mutableListOf()

    fun agregarFactura(factura: Factura) {
        facturas.add(factura)
    }

    fun obtenerFacturas(): List<Factura> {
        return facturas
    }

    fun eliminarFactura(numero: String) {
        facturas.removeIf { it.numero == numero }
    }
}
