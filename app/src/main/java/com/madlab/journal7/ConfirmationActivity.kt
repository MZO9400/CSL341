package com.madlab.journal7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var confirmName: TextView
    private lateinit var confirmUsername: TextView
    private lateinit var confirmPassword: TextView
    private lateinit var confirmButton: Button
    private lateinit var editButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        confirmName = findViewById(R.id.confirm_name)
        confirmUsername = findViewById(R.id.confirm_username)
        confirmPassword = findViewById(R.id.confirm_password)

        confirmButton = findViewById(R.id.confirm_button)
        confirmButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", confirmUsername.text)
            startActivity(intent)
            finish()
        }

        editButton = findViewById(R.id.edit_button)
        editButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            intent.putExtra("name", confirmName.text)
            intent.putExtra("username", confirmUsername.text)
            intent.putExtra("password", confirmPassword.text)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        val bundle = intent.extras
        val name = bundle?.getString("name")
        val username = bundle?.getString("username")
        val password = bundle?.getString("password")
        if (name != null && username != null && password != null) {
            this.confirmName.text = name
            this.confirmUsername.text = username
            this.confirmPassword.text = password
        }
    }
}
