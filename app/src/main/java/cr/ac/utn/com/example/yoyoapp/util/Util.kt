package cr.ac.utn.com.example.yoyoapp.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Util {
    fun formatearFecha(fecha: Date): String {
        val formato = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return formato.format(fecha)
    }

    fun validarCampo(texto: String): Boolean {
        return texto.isNotBlank()
    }
}
