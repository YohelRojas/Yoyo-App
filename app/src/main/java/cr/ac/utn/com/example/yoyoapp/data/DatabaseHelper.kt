package cr.ac.utn.com.example.yoyoapp.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "YoyoApp.db"
        private const val DATABASE_VERSION = 1

        // Tablas
        const val TABLE_PRODUCTOS = "productos"

        // Columnas
        const val COLUMN_ID = "id"
        const val COLUMN_NOMBRE = "nombre"
        const val COLUMN_PRECIO = "precio"
        const val COLUMN_CANTIDAD = "cantidad"
        const val COLUMN_IMAGEN = "imagen"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Crear tabla productos
        val createTableProductos = """
            CREATE TABLE $TABLE_PRODUCTOS (
                $COLUMN_ID TEXT PRIMARY KEY,
                $COLUMN_NOMBRE TEXT NOT NULL,
                $COLUMN_PRECIO REAL NOT NULL,
                $COLUMN_CANTIDAD INTEGER NOT NULL,
                $COLUMN_IMAGEN BLOB
            )
        """.trimIndent()
        db.execSQL(createTableProductos)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUCTOS")
        onCreate(db)
    }
}
