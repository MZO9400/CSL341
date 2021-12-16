package com.madlab.journal5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var username: String
    private lateinit var usernameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usernameTextView = findViewById(R.id.username_text)
    }

    override fun onResume() {
        super.onResume()
        username = intent.getStringExtra("username").toString()
        if (username.isEmpty() || username == "null") {
            finish()
            startActivity(Intent(this, RegisterActivity::class.java))
        } else {
            usernameTextView.text = username
        }
    }
}
