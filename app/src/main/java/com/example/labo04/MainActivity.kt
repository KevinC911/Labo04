package com.example.labo04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var nameEdit: TextInputLayout
    private lateinit var emailEdit: TextInputLayout
    private lateinit var phoneEdit: TextInputLayout
    private lateinit var showResults: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding()
        onClickListeners()
    }

    private fun onClickListeners() {
        showResults.setOnClickListener {
            var intent = Intent(this, Result::class.java)
            intent.putExtra("name", nameEdit.editText?.text.toString())
            intent.putExtra("email", emailEdit.editText?.text.toString())
            intent.putExtra("phone", phoneEdit.editText?.text.toString())
            startActivity(intent)
        }
    }

    private fun binding() {
        nameEdit = findViewById(R.id.name_input)
        emailEdit = findViewById(R.id.email_input)
        phoneEdit = findViewById(R.id.phone_input)
        showResults = findViewById(R.id.save_information)
    }

}