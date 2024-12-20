package cr.ac.utn.com.example.yoyoapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ClientesActivity : AppCompatActivity() {

    private lateinit var tvUsername: TextView
    private lateinit var btnEditar: Button
    private lateinit var btnVolver: Button
    private lateinit var btnGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientes)

        tvUsername = findViewById(R.id.tvUsername)
        btnEditar = findViewById(R.id.btnEditar)
        btnVolver = findViewById(R.id.btnVolver)
        btnGuardar = findViewById(R.id.btnGuardar)

        tvUsername.text = "USERNAME"

        btnEditar.setOnClickListener {
            Toast.makeText(this, "Editar clientes (CRUD no implementado aquí)",
                Toast.LENGTH_SHORT).show()
        }

        btnVolver.setOnClickListener {
            finish()
        }

        btnGuardar.setOnClickListener {
            Toast.makeText(this, "Guardar cambios (CRUD no implementado aquí)",
                Toast.LENGTH_SHORT).show()
        }
    }
}
