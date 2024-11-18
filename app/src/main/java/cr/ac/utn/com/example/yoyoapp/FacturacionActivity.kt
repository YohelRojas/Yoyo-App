package cr.ac.utn.com.example.yoyoapp

import FacturaModel
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class FacturacionActivity : AppCompatActivity() {

    private lateinit var etSubtotal: EditText
    private lateinit var etTotal: EditText
    private lateinit var btnEditarFactura: Button
    private lateinit var btnGuardar: Button
    private lateinit var btnBack: ImageView

    private val facturaModel = FacturaModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facturacion)

        etSubtotal = findViewById(R.id.etSubtotal)
        etTotal = findViewById(R.id.etTotal)
        btnEditarFactura = findViewById(R.id.btnEditarFactura)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnBack = findViewById(R.id.btnBack)

        btnEditarFactura.setOnClickListener {
            val numeroFactura = etSubtotal.text.toString()
            val nuevaTotal = etTotal.text.toString().toDoubleOrNull()

            if (numeroFactura.isEmpty() || nuevaTotal == null) {
                Toast.makeText(this, "Por favor, ingrese un número y total válido", Toast.LENGTH_SHORT).show()
            } else {
                val factura = facturaModel.obtenerFacturaPorNumero(numeroFactura)
                if (factura != null) {
                    factura.total = nuevaTotal
                    facturaModel.actualizarFactura(factura)
                    Toast.makeText(this, "Factura editada con éxito", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Factura no encontrada", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnGuardar.setOnClickListener {
            Toast.makeText(this, "Factura guardada con éxito", Toast.LENGTH_SHORT).show()
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
