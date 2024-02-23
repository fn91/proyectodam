package com.example.aplicacion



import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class CrearEventos : AppCompatActivity() {

    private lateinit var etevento1 : EditText
    private lateinit var  etdia2: EditText
    private lateinit var etnya2: EditText
    private lateinit var etpersonas: EditText
    private lateinit var etFecha2: EditText
    private lateinit var  ubicacion: EditText
    private lateinit var btnext : Button
    private lateinit var btnbevent:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_eventos)



        //Obtenemos referencia de los intent
        etevento1=findViewById(R.id.etevento1)
        etdia2=findViewById(R.id.etdia2)
        etnya2=findViewById(R.id.etnya2)
        etpersonas=findViewById(R.id.etpersonas)
        etFecha2=findViewById(R.id.etFecha2)
        ubicacion=findViewById(R.id.et6ubicacion)
        btnext=findViewById(R.id.btnext)
        btnbevent=findViewById(R.id.btndocu)







        btnext.setOnClickListener{
            //Creamos el intent
            val intent = Intent(this,MenuDocumentos::class.java)

            //Añadimos al intent todos los valores que necesitamos entre actividades
            intent.putExtra("NombreEvento",etevento1.text.toString())
            intent.putExtra("Dia",etdia2.text.toString())
            intent.putExtra("NombreyApellidos",etnya2.toString())
            intent.putExtra("Personas",etpersonas.toString())
            intent.putExtra("Fecha",etFecha2.toString())
            intent.putExtra("Ubicacion",ubicacion.toString())

            // Iniciar
            startActivity(intent)

        }

        btnbevent.setOnClickListener{

            etevento1.setText("")
            etdia2.setText("")
            etnya2.setText("")
            etpersonas.setText("")
            etFecha2.setText("")
            ubicacion.setText("")

            Toast.makeText(this, "Se ha guardado el evento", Toast.LENGTH_SHORT).show()




        }

    }

        }
















