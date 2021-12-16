package com.madlab.journal6

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MapActivity : AppCompatActivity() {
    private lateinit var map: EditText
    private lateinit var mapButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        map = findViewById(R.id.map)
        mapButton = findViewById(R.id.mapButton)

        mapButton.setOnClickListener {
            val query: String = map.text.toString().replace(' ', '+')
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=$query"))
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}
