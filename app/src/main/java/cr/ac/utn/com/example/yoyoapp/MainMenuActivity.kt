package cr.ac.utn.com.example.yoyoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainMenuActivity : AppCompatActivity() {

    private lateinit var btnClientes: ImageView
    private lateinit var btnFacturacion: ImageView
    private lateinit var btnProveedores: ImageView
    private lateinit var btnProductos: ImageView
    private lateinit var btnInventario: ImageView
    private lateinit var btnFacturas: ImageView
    private lateinit var rbSeguridad: RadioButton
    private lateinit var rbCambiarUsuario: RadioButton
    private lateinit var rbSalir: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        btnClientes = findViewById(R.id.btnClientes)
        btnFacturacion = findViewById(R.id.btnFacturacion)
        btnProveedores = findViewById(R.id.btnProveedores)
        btnProductos = findViewById(R.id.btnProductos)
        btnInventario = findViewById(R.id.btnInventario)
        btnFacturas = findViewById(R.id.btnFacturas)

        rbSeguridad = findViewById(R.id.rbSeguridad)
        rbCambiarUsuario = findViewById(R.id.rbCambiarUsuario)
        rbSalir = findViewById(R.id.rbSalir)

        btnClientes.setOnClickListener {
            startActivity(Intent(this, ClientesActivity::class.java))
        }

        btnFacturacion.setOnClickListener {
            startActivity(Intent(this, FacturacionActivity::class.java))
        }

        btnProveedores.setOnClickListener {
        }

        btnProductos.setOnClickListener {
            startActivity(Intent(this, ProductoGestionActivity::class.java))
        }

        btnInventario.setOnClickListener {
            startActivity(Intent(this, InventarioActivity::class.java))
        }

        btnFacturas.setOnClickListener {
            startActivity(Intent(this, FacturaActivity::class.java))
        }

        rbSeguridad.setOnClickListener {
            Toast.makeText(this, "Seguridad seleccionada", Toast.LENGTH_SHORT).show()
        }

        rbCambiarUsuario.setOnClickListener {
        }

        rbSalir.setOnClickListener {
            finish()
        }
    }
}