package cr.ac.utn.com.example.yoyoapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InventarioActivity : AppCompatActivity() {

    // Variables para la UI
    private lateinit var etStockActual: EditText
    private lateinit var etAgregados: EditText
    private lateinit var etStockMaximo: EditText
    private lateinit var btnRestar: Button
    private lateinit var btnSumar: Button
    private lateinit var btnCompletarFaltantes: Button
    private lateinit var btnAceptar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventario)

        // Inicializar los elementos de la UI
        etStockActual = findViewById(R.id.etStockActual)
        etAgregados = findViewById(R.id.etAgregados)
        etStockMaximo = findViewById(R.id.etStockMaximo)
        btnRestar = findViewById(R.id.btnRestar)
        btnSumar = findViewById(R.id.btnSumar)
        btnCompletarFaltantes = findViewById(R.id.btnCompletarFaltantes)
        btnAceptar = findViewById(R.id.btnAceptar)

        // Lógica para restar stock
        btnRestar.setOnClickListener {
            val currentStock = etStockActual.text.toString().toInt()
            if (currentStock > 0) {
                etStockActual.setText((currentStock - 1).toString())
            } else {
                Toast.makeText(this, "No hay más stock disponible", Toast.LENGTH_SHORT).show()
            }
        }

        // Lógica para sumar stock
        btnSumar.setOnClickListener {
            val currentStock = etStockActual.text.toString().toInt()
            etStockActual.setText((currentStock + 1).toString())
        }

        // Lógica para completar faltantes
        btnCompletarFaltantes.setOnClickListener {
            val stockMaximo = etStockMaximo.text.toString().toInt()
            etStockActual.setText(stockMaximo.toString())
        }

        // Lógica para aceptar cambios
        btnAceptar.setOnClickListener {
            Toast.makeText(this, "Inventario actualizado", Toast.LENGTH_SHORT).show()
        }
    }
}
