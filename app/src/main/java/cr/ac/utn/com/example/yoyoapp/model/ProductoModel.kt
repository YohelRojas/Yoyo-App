package cr.ac.utn.com.example.yoyoapp.model

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import cr.ac.utn.com.example.yoyoapp.data.DatabaseHelper
import cr.ac.utn.com.example.yoyoapp.entities.Producto
import java.io.ByteArrayOutputStream

class ProductoModel(private val context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun agregarProducto(producto: Producto) {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_ID, producto.id)
            put(DatabaseHelper.COLUMN_NOMBRE, producto.nombre)
            put(DatabaseHelper.COLUMN_PRECIO, producto.precio)
            put(DatabaseHelper.COLUMN_CANTIDAD, producto.cantidad)
            put(DatabaseHelper.COLUMN_IMAGEN, bitmapToByteArray(producto.imagenBitmap))
        }

        db.insert(DatabaseHelper.TABLE_PRODUCTOS, null, values)
        db.close()
    }

    fun obtenerProductos(): List<Producto> {
        val db = dbHelper.readableDatabase
        val productos = mutableListOf<Producto>()

        val cursor = db.query(
            DatabaseHelper.TABLE_PRODUCTOS,
            null, null, null, null, null, null
        )

        while (cursor.moveToNext()) {
            val id = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID))
            val nombre = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NOMBRE))
            val precio = cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRECIO))
            val cantidad = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_CANTIDAD))
            val imagen = cursor.getBlob(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_IMAGEN))

            productos.add(
                Producto(
                    id = id,
                    nombre = nombre,
                    precio = precio,
                    cantidad = cantidad,
                    imagenBitmap = byteArrayToBitmap(imagen)
                )
            )
        }
        cursor.close()
        db.close()
        return productos
    }

    fun eliminarProducto(id: String) {
        val db = dbHelper.writableDatabase
        db.delete(DatabaseHelper.TABLE_PRODUCTOS, "${DatabaseHelper.COLUMN_ID} = ?", arrayOf(id))
        db.close()
    }

    private fun bitmapToByteArray(bitmap: Bitmap?): ByteArray? {
        if (bitmap == null) return null
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return stream.toByteArray()
    }

    private fun byteArrayToBitmap(byteArray: ByteArray?): Bitmap? {
        return if (byteArray == null) null else BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }
}
