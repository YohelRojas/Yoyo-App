package cr.ac.utn.com.example.yoyoapp

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
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
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class ProductoDetalleActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etPrecio: EditText
    private lateinit var etCantidad: EditText
    private lateinit var ivProducto: ImageView
    private lateinit var btnGuardar: Button

    private val productoModel = ProductoModel()
    private var imagenUri: String? = null

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
    }


    private fun configurarListeners() {
        ivProducto.setOnClickListener {
            mostrarDialogOpciones()
        }

        btnGuardar.setOnClickListener {
            guardarProducto()
        }
    }

    private fun mostrarDialogOpciones() {
        val opciones = arrayOf("Tomar Foto", "Seleccionar de Galería", "Cancelar")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Selecciona una opción")
        builder.setItems(opciones) { dialog, which ->
            when (which) {
                0 -> abrirCamara()
                1 -> abrirGaleria()
                2 -> dialog.dismiss()
            }
        }
        builder.show()
    }

    private fun abrirCamara() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
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
                    guardarImagen(bitmap)
                }
                GALLERY_REQUEST_CODE -> {
                    data?.data?.let { uri ->
                        imagenUri = uri.toString()
                        ivProducto.setImageURI(uri)
                    }
                }
            }
        }
    }

    private fun guardarImagen(bitmap: Bitmap) {
        val filename = "producto_${UUID.randomUUID()}.jpg"
        val file = File(filesDir, filename)
        try {
            FileOutputStream(file).use { out ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
            }
            imagenUri = Uri.fromFile(file).toString()
            ivProducto.setImageBitmap(bitmap)
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Error al guardar imagen", Toast.LENGTH_SHORT).show()
        }
    }

    private fun guardarProducto() {
        val nombre = etNombre.text.toString()
        val precio = etPrecio.text.toString().toDoubleOrNull()
        val cantidad = etCantidad.text.toString().toIntOrNull()

        if (nombre.isEmpty() || precio == null || cantidad == null) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val producto = Producto(
            id = UUID.randomUUID().toString(),
            nombre = nombre,
            precio = precio,
            cantidad = cantidad,
            imagenUri = imagenUri
        )

        productoModel.agregarProducto(producto)
        setResult(RESULT_OK)
        finish()
    }
}
