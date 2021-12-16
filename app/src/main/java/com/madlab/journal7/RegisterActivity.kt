package com.madlab.journal7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class RegisterActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var registerNow: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reigster)
        name = findViewById(R.id.name)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        registerNow = findViewById(R.id.register_button)
        registerNow.setOnClickListener {
            val name = name.text.toString()
            val username = username.text.toString()
            val password = password.text.toString()
            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("username", username)
            bundle.putString("password", password)
            if (isValid(name) && isValid(username) && isValid(password)) {
                val intent = Intent(this, ConfirmationActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
                finish()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Please fill all the fields")
                    .setPositiveButton("OK") { dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val bundle = intent.extras
        val name = bundle?.getString("name")
        val username = bundle?.getString("username")
        val password = bundle?.getString("password")
        if (name != null && username != null && password != null) {
            this.name.setText(name)
            this.username.setText(username)
            this.password.setText(password)
        }
    }

    private fun isValid(data: String): Boolean {
        return data.isNotEmpty() && data != "null"
    }
}
