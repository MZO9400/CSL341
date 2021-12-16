package com.madlab.journal6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var webViewActivityButton: Button
    private lateinit var mapActivityButton: Button
    private lateinit var galleryActivity: Button
    private lateinit var cameraActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webViewActivityButton = findViewById(R.id.webViewActivityButton)
        mapActivityButton = findViewById(R.id.mapActivityButton)
        galleryActivity = findViewById(R.id.galleryButton)
        cameraActivityButton = findViewById(R.id.cameraButton)

        webViewActivityButton.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

    }
}
