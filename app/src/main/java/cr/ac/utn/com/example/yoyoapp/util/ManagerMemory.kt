package cr.ac.utn.com.example.yoyoapp.util

import android.content.Context
import android.content.SharedPreferences

class ManagerMemory(context: Context) {
    private val preferences: SharedPreferences = context.getSharedPreferences("YoyoAppPrefs", Context.MODE_PRIVATE)

    fun guardarValor(clave: String, valor: String) {
        preferences.edit().putString(clave, valor).apply()
    }

    fun obtenerValor(clave: String): String? {
        return preferences.getString(clave, null)
    }

    fun eliminarValor(clave: String) {
        preferences.edit().remove(clave).apply()
    }
}
