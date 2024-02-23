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


class MenuDocumentos : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_documentos)

        val t14nuevo :TextView = findViewById(R.id.t14nuedocu)
        val btndescadocu3: Button=findViewById(R.id.btndescadocu3)
        val bntsudocume2: Button = findViewById(R.id.bntsudocume2)
        t14nuevo.setOnClickListener{

            val intent = Intent(this,CrearDocumentos::class.java)
            startActivity(intent)
            Toast.makeText(this, "Entrando en hacer un nuevo documento", Toast.LENGTH_LONG).show()


        }

        bntsudocume2.setOnClickListener{
            val storage = FirebaseStorage.getInstance()
            val storageReference =
                storage.getReferenceFromUrl("").child("archivo.word")
            var file: File? = null
            try {
                file = File.createTempFile("documento", "word")
            } catch (_: IOException) {
            }
            storageReference.putFile(Uri.fromFile(file))
        }

        btndescadocu3.setOnClickListener {

            descargarEvento()
        }



        }

        private fun descargarEvento() {

            val storage = Firebase.storage
            val storageRef = storage.reference
            val ruta = storageRef.child("word")
            val direccion = storage.getReferenceFromUrl("https://console.firebase.google.com/u/0/project/loginfirebase-ff500/database/loginfirebase-ff500-default-rtdb/data?hl=es")
            var download = storageRef.child("/users/documento.word")

            val twentymegabyte: Long = 10000 * 10000

            download.getBytes(twentymegabyte).addOnSuccessListener {
            }.addOnFailureListener {


                download = storageRef.child("/users/documento.word")
                val filelocal = File.createTempFile("documento", "word")

                download.getFile(filelocal).addOnSuccessListener {


                }.addOnFailureListener {

                }

            }
            storageRef.child("/users/word").downloadUrl.addOnSuccessListener {

            }.addOnFailureListener{

            }

            ruta.getFile(Uri.EMPTY)
            direccion.downloadUrl



    }




}


