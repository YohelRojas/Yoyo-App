package cr.ac.utn.com.example.yoyoapp

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import cr.ac.utn.com.example.yoyoapp.entities.Producto
import cr.ac.utn.com.example.yoyoapp.model.ProductoModel
import java.util.*

class ProductoDetalleActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etPrecio: EditText
    private lateinit var etCantidad: EditText
    private lateinit var ivProducto: ImageView
    private lateinit var btnGuardar: Button
    private lateinit var btnTomarFoto: Button
    private lateinit var btnSeleccionarGaleria: Button

    private val productoModel = ProductoModel(this)
    private var imagenBitmap: Bitmap? = null

    private val CAMERA_REQUEST_CODE = 1001
    private val GALLERY_REQUEST_CODE = 1002

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_detalle)

        inicializarVistas()
        configurarListeners()
    }

    private fun inicializarVistas() {
        etNombre = findViewById(R.id.etNombre)
        etPrecio = findViewById(R.id.etPrecio)
        etCantidad = findViewById(R.id.etCantidad)
        ivProducto = findViewById(R.id.ivProducto)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnTomarFoto = findViewById(R.id.btnTomarFoto)
        btnSeleccionarGaleria = findViewById(R.id.btnSeleccionarGaleria2)
    }

    private fun configurarListeners() {
        btnTomarFoto.setOnClickListener {
            abrirCamara()
        }

        btnSeleccionarGaleria.setOnClickListener {
            abrirGaleria()
        }

        btnGuardar.setOnClickListener {
            guardarProducto()
        }
    }

    private fun abrirCamara() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        } else {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA_REQUEST_CODE)
        }
    }

    private fun abrirGaleria() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                CAMERA_REQUEST_CODE -> {
                    val bitmap = data?.extras?.get("data") as Bitmap
                    imagenBitmap = bitmap
                    ivProducto.setImageBitmap(bitmap)
                    Toast.makeText(this, "Foto tomada con éxito", Toast.LENGTH_SHORT).show()
                }

                GALLERY_REQUEST_CODE -> {
                    val uri = data?.data
                    if (uri != null) {
                        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
                        imagenBitmap = bitmap
                        ivProducto.setImageBitmap(bitmap)
                        Toast.makeText(this, "Imagen seleccionada de la galería", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "No se seleccionó ninguna imagen", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } else {
            Toast.makeText(this, "Operación cancelada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun guardarProducto() {
        val nombre = etNombre.text.toString()
        val precio = etPrecio.text.toString().toDoubleOrNull()
        val cantidad = etCantidad.text.toString().toIntOrNull()

        if (nombre.isEmpty() || precio == null || cantidad == null || imagenBitmap == null) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val producto = Producto(
            id = UUID.randomUUID().toString(),
            nombre = nombre,
            precio = precio,
            cantidad = cantidad,
            imagenBitmap = imagenBitmap
        )

        productoModel.agregarProducto(producto)
        Toast.makeText(this, "Producto guardado exitosamente", Toast.LENGTH_SHORT).show()
        navegarAListaProductos()
    }

    private fun navegarAListaProductos() {
        val intent = Intent(this, ProductoGestion::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}
