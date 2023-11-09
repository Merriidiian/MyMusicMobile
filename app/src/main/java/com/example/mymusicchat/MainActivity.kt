package com.example.mymusicchat

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.mymusicchat.Service.isValidEmail
import com.example.mymusicchat.Service.isValidName
import com.example.mymusicchat.Service.isValidPassword

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var userName : String? = "Сердюков Илья"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun navigateToSignIn(view: View?) {
        supportFragmentManager.commit {
            replace<SignInFragment>(R.id.fragmentContainerView)
            setReorderingAllowed(true)
            addToBackStack("Onboard")
        }
    }

    fun navigateToSignUp(view: View?) {
        supportFragmentManager.commit {
            replace<SignUpFragment>(R.id.fragmentContainerView)
            setReorderingAllowed(true)
            addToBackStack("SignIn")
        }
    }

    fun navigateToHome(view: View?) {
        var emailText = findViewById<EditText>(R.id.emailText)
        var passwordText = findViewById<EditText>(R.id.passwordText)
        if (!emailText.text.isValidEmail()) {
            Toast.makeText(this, "Введите корректный Email", Toast.LENGTH_SHORT).show();
        } else if (!passwordText.text.isValidPassword()) {
            Toast.makeText(this, "Введите корректный пароль", Toast.LENGTH_SHORT).show();
        }
        else {
            val bundle = bundleOf("name" to userName)
            userName = "Сердюков Илья"

            supportFragmentManager.commit {
                replace<HomeFragment>(R.id.fragmentContainerView, args = bundle)
                setReorderingAllowed(true)
            }
        }
    }

    fun navigateToSignInAfterRegistration(view: View?) {
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
            val bundle = bundleOf("name" to nameText.text.toString(), "email" to emailText.text.toString(), "password" to passwordText.text.toString())
            userName = nameText.text.toString()

            supportFragmentManager.commit {
                replace<SignInFragment>(R.id.fragmentContainerView, args = bundle)
                setReorderingAllowed(true)
            }

            Toast.makeText(this, "${userName} зарегестрирован", Toast.LENGTH_SHORT).show();
        }
    }
}