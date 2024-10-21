package cr.ac.utn.com.example.yoyoapp

import android.content.Intent
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

        // Vinculación de vistas
        tvUsername = findViewById(R.id.tvUsername)
        btnEditar = findViewById(R.id.btnEditar)
        btnVolver = findViewById(R.id.btnVolver)
        btnGuardar = findViewById(R.id.btnGuardar)

        // Muestra el nombre de usuario
        tvUsername.text = "USERNAME"

        // Funcionalidad de los botones
        btnEditar.setOnClickListener {
            Toast.makeText(this, "Editar clientes", Toast.LENGTH_SHORT).show()
            // Aquí puedes agregar la lógica para editar clientes
        }

        btnVolver.setOnClickListener {
            finish() // Vuelve a la pantalla anterior
        }

        btnGuardar.setOnClickListener {
            Toast.makeText(this, "Guardar cambios", Toast.LENGTH_SHORT).show()
            // Aquí puedes agregar la lógica para guardar cambios
        }
    }
}
