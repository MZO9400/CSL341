package com.madlab.journal6

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class WebViewActivity : AppCompatActivity() {
    private lateinit var search: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        search = findViewById(R.id.search)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, search.text.toString())
            startActivity(intent)
        }
    }
}
