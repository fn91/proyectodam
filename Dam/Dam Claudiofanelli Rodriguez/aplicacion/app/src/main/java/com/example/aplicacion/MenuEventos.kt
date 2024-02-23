package com.example.aplicacion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage
import java.io.File
import java.io.IOException


class MenuEventos : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_eventos)

        val t10nuevo: TextView = findViewById(R.id.t10nue)
        val btndescargar: Button = findViewById(R.id.btndescargar)
        val btnsubir: Button = findViewById(R.id.btnsubir)

        Firebase.storage
        t10nuevo.setOnClickListener {

            val intent = Intent(this, CrearEventos::class.java)
            startActivity(intent)
            Toast.makeText(this, "Entrando en hacer un nuevo evento", Toast.LENGTH_LONG).show()


        }
        btnsubir.setOnClickListener {
            val storage = FirebaseStorage.getInstance()
            val storageReference =
                storage.getReferenceFromUrl("").child("archivo.pdf")
            var file: File? = null
            try {
                file = File.createTempFile("evento", "pdf")
            } catch (_: IOException) {
            }
            storageReference.putFile(Uri.fromFile(file))
        }

        btndescargar.setOnClickListener {

            descargarEvento()



        }
    }


    private fun descargarEvento() {

        val storage = Firebase.storage
        val storageRef = storage.reference
        val ruta = storageRef.child("pdf")
        val direccion = storage.getReferenceFromUrl("https://.firebase.storage.com")
        var download = storageRef.child("/users/evento.pdf")

        val twentymegabyte: Long = 20000 * 20000

        download.getBytes(twentymegabyte).addOnSuccessListener {

        }.addOnFailureListener {


            download = storageRef.child("/users/evento.pdf")
            val filelocal = File.createTempFile("evento", "pdf")

            download.getFile(filelocal).addOnSuccessListener {


            }.addOnFailureListener {

            }

        }
        storageRef.child("/users/pdf").downloadUrl.addOnSuccessListener {

        }.addOnFailureListener{

        }

        ruta.getFile(Uri.EMPTY)
        direccion.downloadUrl



    }

}




















