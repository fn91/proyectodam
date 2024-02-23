package com.example.aplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Calendario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)
//Añadiendo los botones al menu principal
        val btn14: Button = findViewById( R.id.btn14)


        //Crear eventos
        btn14.setOnClickListener {

            val intent = Intent(this, MenuPrincipal::class.java)
            startActivity(intent)
            Toast.makeText(this, "Vuelta al menu principal", Toast.LENGTH_LONG).show()


        }
    }
}
