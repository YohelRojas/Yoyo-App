package cr.ac.utn.com.example.yoyoapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cr.ac.utn.com.example.yoyoapp.adapters.CustomAdapter
import cr.ac.utn.com.example.yoyoapp.entities.Producto
import cr.ac.utn.com.example.yoyoapp.model.ProductoModel

class ProductoGestion : AppCompatActivity() {

    private lateinit var ivBack: ImageView
    private lateinit var recyclerViewProductos: RecyclerView
    private lateinit var productoAdapter: CustomAdapter
    private lateinit var btnAgregarProducto: Button
    private val productoModel = ProductoModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_gestion)

        inicializarVistas()
        configurarRecyclerView()
        configurarListeners()
    }

    private fun inicializarVistas() {
        ivBack = findViewById(R.id.ivBack)
        recyclerViewProductos = findViewById(R.id.recyclerViewProductos)
        btnAgregarProducto = findViewById(R.id.btnAgregarProducto)
    }

    private fun configurarRecyclerView() {
        val productos = productoModel.obtenerProductos()
        productoAdapter = CustomAdapter(productos.toMutableList()) { producto, action ->
            onProductoAction(producto, action)
        }
        recyclerViewProductos.layoutManager = LinearLayoutManager(this)
        recyclerViewProductos.adapter = productoAdapter
    }

    private fun configurarListeners() {
        ivBack.setOnClickListener {
            finish()
        }

        btnAgregarProducto.setOnClickListener {
            agregarProducto()
        }
    }

    private fun onProductoAction(producto: Producto, action: String) {
        when (action) {
            "edit" -> editarProducto(producto)
            "delete" -> eliminarProducto(producto)
        }
    }

    private fun agregarProducto() {
        val intent = Intent(this, ProductoDetalleActivity::class.java)
        intent.putExtra("action", "add")
        startActivityForResult(intent, REQUEST_CODE_ADD_PRODUCT)
    }

    private fun editarProducto(producto: Producto) {
        val intent = Intent(this, ProductoDetalleActivity::class.java)
        intent.putExtra("action", "edit")
        intent.putExtra("productoId", producto.id)
        startActivityForResult(intent, REQUEST_CODE_EDIT_PRODUCT)
    }

    private fun eliminarProducto(producto: Producto) {
        productoModel.eliminarProducto(producto.id)
        productoAdapter.actualizarLista(productoModel.obtenerProductos().toMutableList())
        Toast.makeText(this, "Producto eliminado: ${producto.nombre}", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_ADD_PRODUCT, REQUEST_CODE_EDIT_PRODUCT -> {
                    productoAdapter.actualizarLista(productoModel.obtenerProductos().toMutableList())
                }
            }
        }
    }

    companion object {
        const val REQUEST_CODE_ADD_PRODUCT = 1
        const val REQUEST_CODE_EDIT_PRODUCT = 2
    }
}
