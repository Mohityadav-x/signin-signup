package com.example.singin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.content.Intent

class MainActivity : AppCompatActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
         val signup=findViewById<Button>(R.id.btnsignup)
        val etname=findViewById<TextInputEditText>(R.id.etname)
        val etmail=findViewById<TextInputEditText>(R.id.etmail)
        val etpass=findViewById<TextInputEditText>(R.id.etpass)
        val etuserid=findViewById<TextInputEditText>(R.id.etuid)
         signup.setOnClickListener{
            val name=etname.text.toString()
            val mail=etmail.text.toString()
            val uniqueid=etuserid.text.toString()
            val pass=etpass.text.toString()
            val user =user(name, mail, pass, uniqueid)
            database= FirebaseDatabase.getInstance().getReference("user")
            database.child(uniqueid).setValue(user).addOnSuccessListener {
                etname.text?.clear()
                etmail.text?.clear()
                etpass.text?.clear()
                etuserid.text?.clear()
                Toast.makeText(this,"user registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }
        val signintext=findViewById<TextView>(R.id.tvsignin)
        signintext.setOnClickListener{
            val intent= Intent (this, signin2::class.java)
            startActivity(intent)
        }
    }
}