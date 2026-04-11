package com.example.singin

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class final2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_final2)
val name=intent.getStringExtra(signin2.KEY1)
        val mail=intent.getStringExtra(signin2.KEY2)
        val password=intent.getStringExtra(signin2.KEY4)

        val welcome=findViewById<TextView>(R.id.welcome)
        val mailText=findViewById<TextView>(R.id.mailtxt)
        val pass=findViewById<TextView>(R.id.passtxt)
        welcome.text="Welcome, $name"
        mailText.text="Mail: $mail"
        pass.text="password: $password"
    }
}