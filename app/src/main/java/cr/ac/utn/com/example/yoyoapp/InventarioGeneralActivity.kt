package cr.ac.utn.com.example.yoyoapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InventarioGeneralActivity : AppCompatActivity() {

    private lateinit var ivBimbo: ImageView
    private lateinit var ivCocaCola: ImageView
    private lateinit var ivPepsi: ImageView
    private lateinit var ivBigCola: ImageView
    private lateinit var ivAlmacenSA: ImageView
    private lateinit var ivCarnesLaFinca: ImageView

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventario_general)

        // Enlace de ImageViews con las imágenes de los proveedores
        ivBimbo = findViewById(R.id.ivBimbo)
        ivCocaCola = findViewById(R.id.ivCocaCola)
        ivPepsi = findViewById(R.id.ivPepsi)
        ivBigCola = findViewById(R.id.ivBigCola)
        ivAlmacenSA = findViewById(R.id.ivAlmacenSA)
        ivCarnesLaFinca = findViewById(R.id.ivCarnesLaFinca)

        // Configuración de los eventos de clic para cada ImageView
        ivBimbo.setOnClickListener {
            Toast.makeText(this, "Seleccionado: Bimbo", Toast.LENGTH_SHORT).show()
            // Aquí puedes agregar la lógica para redirigir a otra pantalla si es necesario
        }

        ivCocaCola.setOnClickListener {
            Toast.makeText(this, "Seleccionado: CocaCola", Toast.LENGTH_SHORT).show()
        }

        ivPepsi.setOnClickListener {
            Toast.makeText(this, "Seleccionado: Pepsi", Toast.LENGTH_SHORT).show()
        }

        ivBigCola.setOnClickListener {
            Toast.makeText(this, "Seleccionado: BigCola", Toast.LENGTH_SHORT).show()
        }

        ivAlmacenSA.setOnClickListener {
            Toast.makeText(this, "Seleccionado: AlmacenS.A", Toast.LENGTH_SHORT).show()
        }

        ivCarnesLaFinca.setOnClickListener {
            Toast.makeText(this, "Seleccionado: Carnes La Finca", Toast.LENGTH_SHORT).show()
        }

        // Botón de volver
        val btnVolver = findViewById<ImageView>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish()
        }
    }
}
