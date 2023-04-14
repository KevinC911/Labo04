package com.example.labo04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class Result : AppCompatActivity() {


    private lateinit var shareInfo: Button
    private lateinit var nameData: String
    private lateinit var emailData: String
    private lateinit var phoneData: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val nameSet = intent.getStringExtra("name").toString()
        val emailSet = intent.getStringExtra("email").toString()
        val phoneSet = intent.getStringExtra("phone").toString()
        nameData = nameSet
        emailData = emailSet
        phoneData = phoneSet
                bind()
                setOnClickListener()


                findViewById<TextView>(R.id.name_set).apply{
                    text = nameSet
                }
                findViewById<TextView>(R.id.email_set).apply{
                    text = emailSet
                }
                findViewById<TextView>(R.id.phone_set).apply{
                    text = phoneSet
            }

    }

    private fun setOnClickListener() {
        shareInfo.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${getString(R.string.name_const)} $nameData \n" +
                        "${getString(R.string.email_const)} $emailData \n" +
                        "${getString(R.string.phone_const)} $phoneData")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }


    private fun bind() {
        shareInfo = findViewById(R.id.share_info)
    }
}