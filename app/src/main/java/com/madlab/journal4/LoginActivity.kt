package com.madlab.journal4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.loginButton)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        loginButton.setOnClickListener {
            val usernameText = username.text.toString()
            val passwordText = password.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", usernameText)
            intent.putExtra("password", passwordText)
            startActivity(intent)
            finish()
        }
    }
}
