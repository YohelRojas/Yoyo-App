package cr.ac.utn.com.example.yoyoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProductoGestion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_gestion)

        val ivBack = findViewById<ImageView>(R.id.ivBack)
        ivBack.setOnClickListener {
            finish()
        }

        val btnAgregarProducto = findViewById<Button>(R.id.btnAgregarProducto)
        btnAgregarProducto.setOnClickListener {
            Toast.makeText(this, "Agregar nuevo producto", Toast.LENGTH_SHORT).show()

        }

        val btnEditarProducto = findViewById<Button>(R.id.btnEditarProducto)
        btnEditarProducto.setOnClickListener {
            Toast.makeText(this, "Editar producto seleccionado", Toast.LENGTH_SHORT).show()

        }
    }
}
