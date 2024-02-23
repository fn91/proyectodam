package com.example.aplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Olvidarcontrasena : AppCompatActivity() {
    private var t2Email: EditText? = null
    private var btrecupe: Button? = null

    // Referencias Firebase
    private var auth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_olvidarcontrasena)
        recuperar()
    }

    private   fun recuperar () {
        t2Email= findViewById<View>(R.id.t2Email) as EditText
        btrecupe=findViewById<View>(R.id.btrecupe) as Button

        auth = FirebaseAuth.getInstance()

        btrecupe!!.setOnClickListener { passwordReset()}

    }

    private fun passwordReset() {

        val email = t2Email?.text.toString()

        if (!TextUtils.isEmpty(email)) {
            auth!!
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Ha sido enviado ", Toast.LENGTH_LONG).show()

                        irBase()

                    } else {

                        Toast.makeText(this, "El correo no es correcto ", Toast.LENGTH_LONG).show()

                    }
                }
        } else {
            Toast.makeText(this, "Añadir el correo ", Toast.LENGTH_LONG).show()
        }
    }

    private fun irBase  (){
        val intent = Intent(this,MenuLogin::class.java)
        startActivity(intent)
        Toast.makeText(this, "Vuelta al menu login", Toast.LENGTH_LONG).show()


    }

}

