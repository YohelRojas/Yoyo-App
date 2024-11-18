package cr.ac.utn.com.example.yoyoapp.adapters

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cr.ac.utn.com.example.yoyoapp.R
import cr.ac.utn.com.example.yoyoapp.entities.Producto

class CustomAdapter(
    private var productos: MutableList<Producto>,
    private val onProductoClickListener: (Producto, String) -> Unit
) : RecyclerView.Adapter<CustomAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecio)
        val tvCantidad: TextView = itemView.findViewById(R.id.tvCantidad)
        val ivProducto: ImageView = itemView.findViewById(R.id.ivProducto)
        val btnEditar: ImageButton = itemView.findViewById(R.id.btnEditar)
        val btnEliminar: ImageButton = itemView.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.tvNombre.text = producto.nombre
        holder.tvPrecio.text = "₡${producto.precio}"
        holder.tvCantidad.text = "Cantidad: ${producto.cantidad}"

        if (producto.imagenBitmap != null) {
            holder.ivProducto.setImageBitmap(producto.imagenBitmap)
        } else {

            holder.ivProducto.setImageResource(R.drawable.ic_placeholder_image)
        }

        holder.btnEditar.setOnClickListener {
            onProductoClickListener(producto, "edit")
        }

        holder.btnEliminar.setOnClickListener {
            onProductoClickListener(producto, "delete")
        }
    }

    override fun getItemCount() = productos.size

    @SuppressLint("NotifyDataSetChanged")
    fun actualizarLista(nuevaLista: MutableList<Producto>) {
        productos = nuevaLista
        notifyDataSetChanged()
    }
}
