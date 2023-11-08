package com.example.mymusicchat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chatapp.Service.isValidEmail
import com.example.chatapp.Service.isValidPassword

class SignInActivity : AppCompatActivity() {
    private val TAG : String = "SignInActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        var emailText = findViewById(R.id.emailText) as EditText
        var passwordText = findViewById(R.id.passwordText) as EditText

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        emailText.setText(email)
        passwordText.setText(password)

        Log.d(TAG, "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    fun logIn(view: View?) {
        var emailText = findViewById<EditText>(R.id.emailText)
        var passwordText = findViewById<EditText>(R.id.passwordText)
        if (!emailText.text.isValidEmail()) {
            Toast.makeText(this, "Введите корректный Email", Toast.LENGTH_SHORT).show();
        } else if (!passwordText.text.isValidPassword()) {
            Toast.makeText(this, "Введите корректный пароль", Toast.LENGTH_SHORT).show();
        }
        else {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

}