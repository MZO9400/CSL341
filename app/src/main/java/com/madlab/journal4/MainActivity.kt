package com.madlab.journal4

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


class MainActivity : AppCompatActivity() {
    private lateinit var container: ViewGroup
    private lateinit var homeText: TextView
    private lateinit var authButton: Button
    private lateinit var user: TextView

    private var isLoggedIn: Boolean = false
    private var userId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container = findViewById(R.id.activity_main)
        homeText = findViewById(R.id.homeText)
        authButton = findViewById(R.id.authButton)
    }

    override fun onResume() {
        super.onResume()
        val intent = intent
        userId = intent.getStringExtra("username").toString()

        isLoggedIn = userId.isNotEmpty()

        setupLoginButton()
        if (isLoggedIn) {
            user = TextView(this)
            user.text = userId
            user.id = View.generateViewId()
            user.layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            container.addView(user)

            val constraintSet = ConstraintSet()
            constraintSet.clone(container as ConstraintLayout)

            constraintSet.connect(user.id, ConstraintSet.TOP, authButton.id, ConstraintSet.BOTTOM)
            constraintSet.connect(user.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT)
            constraintSet.connect(user.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)

            constraintSet.setMargin(user.id, ConstraintSet.TOP, 32)

            constraintSet.applyTo(container as ConstraintLayout)
        }
    }

    private fun setupLoginButton() {
        if (isLoggedIn) {
            authButton.text = getString(R.string.logout_text)
            authButton.setOnClickListener { logout() }
        } else {
            authButton.text = getString(R.string.login_text)
            authButton.setOnClickListener { login() }
        }
    }

    private fun login() {

    }

    private fun logout() {
        authButton.text = getString(R.string.login_text)
        isLoggedIn = false
        userId = ""
        container.removeView(user)
    }
}
