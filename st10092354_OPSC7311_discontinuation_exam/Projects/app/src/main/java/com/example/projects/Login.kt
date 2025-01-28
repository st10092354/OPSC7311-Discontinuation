package com.example.projects

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {

    lateinit var etUser: EditText
    private lateinit var Password: EditText
    lateinit var btnLogin: Button
    lateinit var back: ImageView

    //Creation of the Firebase object
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //The following information was taken from Geeks for Geeks
        //Author: ayushpandey
        //Link: https://www.geeksforgeeks.org/login-and-registration-in-android-using-firebase-in-kotlin/


        //View Binding values
        etUser = findViewById(R.id.etUser)
        Password = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        back = findViewById(R.id.back)

        //Initialising Firebase authentication object
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }

    fun SignUp(view: View?) {
        val intent = Intent(this, Registration::class.java)
        startActivity(intent)
    }


    private fun login() {
        val username = etUser.text.toString()
        val password = Password.text.toString()

        // calling signInWithEmailAndPassword(email, pass)
        // method utilising the Firebase authentication object
        // On successful response Showcase a Toast
        auth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Login has failed", Toast.LENGTH_SHORT).show()
                }
            }

    }

}
