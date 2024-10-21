package cr.ac.utn.com.example.yoyoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enlace de los elementos del layout
        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etContrasena = findViewById<EditText>(R.id.etContrasena)
        val btnAceptar = findViewById<Button>(R.id.btnAceptar)
        val tvSignUp = findViewById<TextView>(R.id.tvSignUp)

        // Lógica del botón "Aceptar"
        btnAceptar.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val contrasena = etContrasena.text.toString()

            if (usuario.isNotEmpty() && contrasena.isNotEmpty()) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                // Aquí puedes redirigir a la pantalla principal después de un login exitoso
                // startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Por favor, ingresa usuario y contraseña", Toast.LENGTH_SHORT).show()
            }
        }

        // Redirección al registro de usuario al hacer clic en "Sign up"
        tvSignUp.setOnClickListener {
            Toast.makeText(this, "Redirigiendo a registro", Toast.LENGTH_SHORT).show()
            // Aquí puedes redirigir a la pantalla de registro
            // startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}
