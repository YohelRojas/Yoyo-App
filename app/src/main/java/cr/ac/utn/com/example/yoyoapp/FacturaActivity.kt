package cr.ac.utn.com.example.yoyoapp

import FacturaModel
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cr.ac.utn.com.example.yoyoapp.entities.Factura

class FacturaActivity : AppCompatActivity() {

    // Declaración de vistas
    private lateinit var ivBack: ImageView
    private lateinit var etNumeroFactura: EditText
    private lateinit var etCliente: EditText
    private lateinit var etProductos: EditText
    private lateinit var etTotal: EditText
    private lateinit var btnImprimir: Button
    private lateinit var btnCancelar: Button
    private lateinit var btnGuardar: Button
    private lateinit var tvUsername: TextView

    private val facturaModel = FacturaModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura)

        // Inicialización de vistas
        inicializarVistas()

        // Configuración de listeners
        configurarListeners()
    }

    private fun inicializarVistas() {
        ivBack = findViewById(R.id.ivBack)
        etNumeroFactura = findViewById(R.id.etNumeroFactura)
        etCliente = findViewById(R.id.etCliente)
        etProductos = findViewById(R.id.etProductos)
        etTotal = findViewById(R.id.etTotal)
        btnImprimir = findViewById(R.id.btnImprimir)
        btnCancelar = findViewById(R.id.btnCancelar)
        btnGuardar = findViewById(R.id.btnGuardar)
        tvUsername = findViewById(R.id.tvUsername)
        tvUsername.text = "USERNAME"
    }

    private fun configurarListeners() {
        ivBack.setOnClickListener {
            finish()
        }

        btnImprimir.setOnClickListener {
            val numeroFactura = etNumeroFactura.text.toString()
            if (numeroFactura.isEmpty()) {
                Toast.makeText(this, "Ingrese el número de factura",
                    Toast.LENGTH_SHORT).show()
            } else {
                val factura = facturaModel.obtenerFacturaPorNumero(numeroFactura)
                if (factura != null) {
                    Toast.makeText(this, "Imprimiendo factura: ${factura.numero}",
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Factura no encontrada",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnCancelar.setOnClickListener {
            limpiarCampos()
            Toast.makeText(this, "Campos limpiados",
                Toast.LENGTH_SHORT).show()
        }

        btnGuardar.setOnClickListener {
            guardarFactura()
        }
    }

    private fun guardarFactura() {
        val numeroFactura = etNumeroFactura.text.toString()
        val cliente = etCliente.text.toString()
        val productos = etProductos.text.toString()
        val total = etTotal.text.toString().toDoubleOrNull()

        if (numeroFactura.isEmpty() || cliente.isEmpty() || productos.isEmpty() || total == null) {
            Toast.makeText(this, "Por favor, complete todos los campos",
                Toast.LENGTH_SHORT).show()
        } else {
            val nuevaFactura = Factura(
                numero = numeroFactura,
                cliente = cliente,
                productos = productos,
                total = total
            )
            facturaModel.agregarFactura(nuevaFactura)
            Toast.makeText(this, "Factura guardada exitosamente",
                Toast.LENGTH_SHORT).show()
            limpiarCampos()
        }
    }

    private fun limpiarCampos() {
        etNumeroFactura.text.clear()
        etCliente.text.clear()
        etProductos.text.clear()
        etTotal.text.clear()
    }
}
