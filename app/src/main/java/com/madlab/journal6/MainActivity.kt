package com.madlab.journal6

import android.R.attr
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private val PICK_IMAGE = 1
    private val REQUEST_IMAGE_CAPTURE = 2

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

        mapActivityButton.setOnClickListener {
            startActivity(Intent(this, MapActivity::class.java))
        }

        galleryActivity.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
        }

        cameraActivityButton.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode === RESULT_OK) when (requestCode) {
            PICK_IMAGE -> {
                val selectedImage: Uri = data?.data!!
                try {
                    val bitmap = ImageDecoder.decodeBitmap(
                        ImageDecoder.createSource(contentResolver, selectedImage))
                    val intent = Intent(this, ImageViewActivity::class.java)
                    intent.putExtra("image", bitmap)
                    startActivity(intent)
                } catch (e: IOException) {
                    Log.i("TAG", "Some exception $e")
                }
            }
            REQUEST_IMAGE_CAPTURE -> {
                val thumbnail: Bitmap = data?.extras?.get("data") as Bitmap
                val intent = Intent(this, ImageViewActivity::class.java)
                intent.putExtra("image", thumbnail)
                startActivity(intent)
            }
        }
    }
}
