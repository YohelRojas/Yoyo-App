import cr.ac.utn.com.example.yoyoapp.data.ManagerMemory
import cr.ac.utn.com.example.yoyoapp.entities.Factura

class FacturaModel {

    // Método para agregar una nueva factura
    fun agregarFactura(factura: Factura) {
        ManagerMemory.add(factura)
    }

    // Método para obtener todas las facturas
    fun obtenerFacturas(): List<Factura> {
        return ManagerMemory.getAll().filterIsInstance<Factura>()
    }

    // Método para actualizar una factura existente
    fun actualizarFactura(factura: Factura) {
        ManagerMemory.update(factura)
    }

    // Método para eliminar una factura por número
    fun eliminarFactura(numero: String) {
        val facturaAEliminar = ManagerMemory.getByid(numero) as? Factura
        facturaAEliminar?.let { ManagerMemory.remove(it) }
    }

    // Método para obtener una factura por su número
    fun obtenerFacturaPorNumero(numero: String): Factura? {
        return ManagerMemory.getByid(numero) as? Factura
    }
}
