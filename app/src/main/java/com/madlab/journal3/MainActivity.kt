package com.madlab.journal3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputOne: EditText
    private lateinit var inputTwo: EditText
    private lateinit var result: TextView
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputOne = findViewById(R.id.numberOne)
        inputTwo = findViewById(R.id.numberTwo)
        result = findViewById(R.id.result)
        buttonAdd = findViewById(R.id.addButton)
        buttonSubtract = findViewById(R.id.subtractButton)
        buttonMultiply = findViewById(R.id.multiplyButton)
        buttonDivide = findViewById(R.id.divideButton)

        result.text = getString(R.string.result_default)

        buttonAdd.setOnClickListener {
            val numberOne = inputOne.text.toString().toFloatOrNull()
            val numberTwo = inputTwo.text.toString().toFloatOrNull()
            if (numberOne != null && numberTwo != null) {
                result.text = (numberOne + numberTwo).toString()
            } else {
                result.text = getString(R.string.result_error)
            }
        }
        buttonSubtract.setOnClickListener {
            val numberOne = inputOne.text.toString().toFloatOrNull()
            val numberTwo = inputTwo.text.toString().toFloatOrNull()
            if (numberOne != null && numberTwo != null) {
                result.text = (numberOne - numberTwo).toString()
            } else {
                result.text = getString(R.string.result_error)
            }
        }
        buttonMultiply.setOnClickListener {
            val numberOne = inputOne.text.toString().toFloatOrNull()
            val numberTwo = inputTwo.text.toString().toFloatOrNull()
            if (numberOne != null && numberTwo != null) {
                result.text = (numberOne * numberTwo).toString()
            } else {
                result.text = getString(R.string.result_error)
            }
        }
        buttonDivide.setOnClickListener {
            val numberOne = inputOne.text.toString().toFloatOrNull()
            val numberTwo = inputTwo.text.toString().toFloatOrNull()
            if (numberOne != null && numberTwo != null) {
                result.text = (numberOne / numberTwo).toString()
            } else {
                result.text = getString(R.string.result_error)
            }
        }
    }
}
