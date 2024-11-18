import cr.ac.utn.com.example.yoyoapp.data.ManagerMemory
import cr.ac.utn.com.example.yoyoapp.entities.Factura

class FacturaModel {

    fun agregarFactura(factura: Factura) {
        ManagerMemory.add(factura)
    }
    fun actualizarFactura(factura: Factura) {
        ManagerMemory.update(factura)
    }
    fun obtenerFacturaPorNumero(numero: String): Factura? {
        return ManagerMemory.getByid(numero) as? Factura
    }
}
