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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.properties.Delegates


class MenuRegistro : AppCompatActivity() {
    private lateinit var txtName: EditText
    private lateinit var txtLastName: EditText
    private lateinit var txtEmail: EditText
    private lateinit var txtPassword: EditText
    private lateinit var progressBar: ProgressDialog
    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    private lateinit var volverLogin: Button

    private var firstName by Delegates.notNull<String>()
    private var lastName by Delegates.notNull<String>()
    private var email by Delegates.notNull<String>()
    private var password by Delegates.notNull<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_registro)
        initialise()

        volverLogin.setOnClickListener {

            val intent =Intent (this,MenuLogin::class.java)
            startActivity(intent)


        }

    }
        private fun initialise() {

            txtName = findViewById(R.id.Nombre)
            txtLastName = findViewById(R.id.Apellidos)
            txtEmail = findViewById(R.id.Email)
            txtPassword = findViewById(R.id.Password)
            progressBar = ProgressDialog(this)
            volverLogin=findViewById(R.id.volverLogin)
             database = FirebaseDatabase.getInstance()
             auth = FirebaseAuth.getInstance()
             databaseReference = database.reference.child("Users")
        }



        private fun createNewAccount() {


        firstName = txtName.text.toString()
        lastName = txtLastName.text.toString()
        email = txtEmail.text.toString()
        password = txtPassword.text.toString()


        if (!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName)
            && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            progressBar.setMessage("Usuario registrado...")
            progressBar.show()


            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {




                    val user:FirebaseUser = auth.currentUser!!

                    verifyEmail(user)

                    val currentUserDb = databaseReference.child(user.uid)

                    currentUserDb.child("firstName").setValue(firstName)
                    currentUserDb.child("lastName").setValue(lastName)

                    updateUserInfoAndGoHome()

                }.addOnFailureListener{

                    Toast.makeText(this, "Todo ah salido correcto.",
                        Toast.LENGTH_SHORT).show()
                }

        } else {
            Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
        }
    }


             fun register(view: View){
                createNewAccount()
                     }

         private fun updateUserInfoAndGoHome() {

             val intent = Intent(this,MenuLogin::class.java)
             intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
             startActivity(intent)

             progressBar.hide()

    }
            private fun verifyEmail(user: FirebaseUser) {
            user.sendEmailVerification()
            .addOnCompleteListener(this) {

                    task ->
                if (task.isSuccessful) {
                    Toast.makeText(this,
                        "Email " + user.email,
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,
                        "Error al verificar el correo ",
                        Toast.LENGTH_SHORT).show()
                    }
                 }
            }



        }








