package com.example.aplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MenuPrincipal : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)


        //Añadiendo los botones al menu principal
        val btn6: Button = findViewById(R.id.calendario)
        val btn7: Button = findViewById(R.id.close)
        val crearEventos:Button=findViewById(R.id.creareven)
        val crearDocumentos:Button=findViewById(R.id.creardocus)

        crearEventos.setOnClickListener{
            val intent =Intent(this, MenuEventos::class.java)
            startActivity(intent)
            Toast.makeText(this,"Eventos",Toast.LENGTH_LONG).show()


        }

        crearDocumentos.setOnClickListener{
            val intent =Intent(this, MenuDocumentos::class.java)
            startActivity(intent)
            Toast.makeText(this,"Documentos",Toast.LENGTH_LONG).show()

        }



        // Calendario
        btn6.setOnClickListener {

            val intent = Intent(this, Calendario::class.java)
            startActivity(intent)
            Toast.makeText(this, "Calendario", Toast.LENGTH_LONG).show()


        }
        btn7.setOnClickListener {

            val intent = Intent(this, MenuLogin::class.java)
            startActivity(intent)
            closeContextMenu()
            Toast.makeText(this, "Cerrando la Aplicacion", Toast.LENGTH_LONG).show()


        }
    }

    }


