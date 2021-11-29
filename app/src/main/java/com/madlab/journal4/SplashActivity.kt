package com.madlab.journal4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Thread {
            try {
                Thread.sleep(2500)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }.start()
    }
}
