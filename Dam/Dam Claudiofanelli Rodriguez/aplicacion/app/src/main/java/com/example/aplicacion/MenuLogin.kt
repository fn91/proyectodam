@file:Suppress("DEPRECATION")

package com.example.aplicacion

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlin.properties.Delegates

class MenuLogin : AppCompatActivity() {

    private var email by Delegates.notNull<String>()
    private var password by Delegates.notNull<String>()
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var mProgressBar: ProgressDialog
    private lateinit var btnLogin:Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_login)
        initialise()


        btnLogin.setOnClickListener {

            val intent = Intent(this, MenuPrincipal::class.java)
            startActivity(intent)

            Toast.makeText(this, "Te has logeado correctamente", Toast.LENGTH_LONG).show()


        }
    }

    private fun initialise() {
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        mProgressBar = ProgressDialog(this)
        btnLogin=findViewById(R.id.btnLogin)
        mAuth = FirebaseAuth.getInstance()

    }

    private fun loginUser() {

        email = etEmail.text.toString()
        password = etPassword.text.toString()

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {


            mProgressBar.setMessage("Registering User...")
            mProgressBar.show()


            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {


                        task ->
                    if (task.isSuccessful) {

                        goHome()
                    } else {

                        Toast.makeText(this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }
    }


    private fun goHome() {

        mProgressBar.hide()

        val intent = Intent(this, MenuPrincipal::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }


    fun login(view: View) {
        loginUser()
    }


    fun forgotPassword(view: View) {
        startActivity(Intent(this, Olvidarcontrasena::class.java))
    }


    fun register(view: View) {
        startActivity(Intent(this, MenuRegistro::class.java))
    }
}





