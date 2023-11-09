package com.example.mymusicchat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mymusicchat.Service.isValidEmail
import com.example.mymusicchat.Service.isValidName
import com.example.mymusicchat.Service.isValidPassword
import com.example.mymusicchat.Service.User

class SignUpActivity : AppCompatActivity() {
    private val TAG : String = "SignUpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        Log.d(TAG, "onCreate")
    }

    fun signUp(view: View?) {
        var nameText = findViewById<EditText>(R.id.nameText)
        var emailText = findViewById<EditText>(R.id.emailText)
        var passwordText = findViewById<EditText>(R.id.passwordText)

        if (!nameText.text.isValidName()) {
            Toast.makeText(this, "Введите корректное имя", Toast.LENGTH_SHORT).show()
        } else if (!emailText.text.isValidEmail()) {
            Toast.makeText(this, "Введите корректный Email", Toast.LENGTH_SHORT).show();
        } else if (!passwordText.text.isValidPassword()) {
            Toast.makeText(this, "Введите корректный пароль", Toast.LENGTH_SHORT).show()
        }
        else {
            val intent = Intent(this, SignInActivity::class.java)

            val user = User(nameText.text.toString(), emailText.text.toString(), passwordText.text.toString())
            intent.putExtra("user", user)

            startActivity(intent)
        }
    }
}