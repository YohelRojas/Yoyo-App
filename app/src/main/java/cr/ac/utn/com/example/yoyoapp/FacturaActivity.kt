package cr.ac.utn.com.example.yoyoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FacturaActivity : AppCompatActivity() {

    private lateinit var ivBack: ImageView
    private lateinit var etNumeroFactura: EditText
    private lateinit var etCliente: EditText
    private lateinit var etProductos: EditText
    private lateinit var etTotal: EditText
    private lateinit var btnImprimir: Button
    private lateinit var btnCancelar: Button
    private lateinit var btnGuardar: Button
    private lateinit var tvUsername: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura)

        // Vinculación de vistas
        ivBack = findViewById(R.id.ivBack)
        etNumeroFactura = findViewById(R.id.etNumeroFactura)
        etCliente = findViewById(R.id.etCliente)
        etProductos = findViewById(R.id.etProductos)
        etTotal = findViewById(R.id.etTotal)
        btnImprimir = findViewById(R.id.btnImprimir)
        btnCancelar = findViewById(R.id.btnCancelar)
        btnGuardar = findViewById(R.id.btnGuardar)
        tvUsername = findViewById(R.id.tvUsername)

        // Muestra el nombre de usuario actual
        tvUsername.text = "USERNAME" // Puedes ajustar esto con el usuario autenticado

        // Botón de regresar al menú anterior
        ivBack.setOnClickListener {
            finish() // Vuelve a la pantalla anterior
        }

        // Funcionalidad del botón Imprimir
        btnImprimir.setOnClickListener {
            val numeroFactura = etNumeroFactura.text.toString()

            if (numeroFactura.isEmpty()) {
                Toast.makeText(this, "Ingrese el número de factura", Toast.LENGTH_SHORT).show()
            } else {
                // Lógica para imprimir la factura (ejemplo de acción)
                Toast.makeText(this, "Imprimiendo factura: $numeroFactura", Toast.LENGTH_SHORT).show()
                // Aquí puedes agregar lógica adicional para la impresión
            }
        }

        // Funcionalidad del botón Cancelar
        btnCancelar.setOnClickListener {
            // Limpia todos los campos
            etNumeroFactura.text.clear()
            etCliente.text.clear()
            etProductos.text.clear()
            etTotal.text.clear()

            Toast.makeText(this, "Campos limpiados", Toast.LENGTH_SHORT).show()
        }

        // Funcionalidad del botón Guardar
        btnGuardar.setOnClickListener {
            val numeroFactura = etNumeroFactura.text.toString()
            val cliente = etCliente.text.toString()
            val productos = etProductos.text.toString()
            val total = etTotal.text.toString()

            if (numeroFactura.isEmpty() || cliente.isEmpty() || productos.isEmpty() || total.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Lógica para guardar la factura (ejemplo de acción)
                Toast.makeText(this, "Factura guardada exitosamente", Toast.LENGTH_SHORT).show()
                // Aquí puedes agregar lógica adicional para guardar la factura
            }
        }
    }
}
