package com.example.aplicacion

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CrearDocumentos : AppCompatActivity() {
    //Añadiendo los campos de los datos que vamos a utilizar para crear eventos
    private lateinit var etdocumento : EditText
    private lateinit var  etdia: EditText
    private lateinit var edinya: EditText
    private lateinit var ediFecha: EditText
    private lateinit var  dispositivo: EditText
    private lateinit var  descripcion: EditText
    private lateinit var btnext : Button
    private lateinit var btndocu: Button




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_documento)


        //Obtenemos referencia de los intent
        etdocumento=findViewById(R.id.etdocumento)
        etdia=findViewById(R.id.etdia)
        edinya=findViewById(R.id.edinya)
        ediFecha=findViewById(R.id.ediFecha)
        dispositivo=findViewById(R.id.dispositivo)
        descripcion=findViewById(R.id.descripcion)
        btnext=findViewById(R.id.btnext)
        btndocu=findViewById(R.id.btndocu)

        btnext.setOnClickListener{
            //Creamos el intent
            val intent = Intent(this,MenuDocumentos::class.java)

            //Añadimos al intent todos los valores que necesitamos entre actividades
            intent.putExtra("NombreDocumento",etdocumento.text.toString())
            intent.putExtra("Dia",etdia.text.toString())
            intent.putExtra("NombreyApellidos",edinya.toString())
            intent.putExtra("Personas",ediFecha.toString())
            intent.putExtra("Fecha",ediFecha.toString())
            intent.putExtra("Dispositivo",dispositivo.toString())
            intent.putExtra("Descripcion",descripcion.toString())
            // Iniciar
            startActivity(intent)
            Toast.makeText(this, "Se ha guardado el documento", Toast.LENGTH_SHORT).show()

        }

        btndocu.setOnClickListener{

            etdocumento.setText("")
            etdia.setText("")
            edinya.setText("")
            ediFecha.setText("")
            dispositivo.setText("")
            descripcion.setText("")




        }


    }
}