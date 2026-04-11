package com.example.singin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signin2 : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    companion object{
        const val KEY1="com.example.signin2.name"
        const val KEY2="com.example.signin2.mail"
        const val KEY3="com.example.signin2.id"
        const val KEY4="com.example.signin2.pass"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signin2)

        val signInButton = findViewById<Button>(R.id.btnsignin)
        val username = findViewById<TextInputEditText>(R.id.usernameid)
        signInButton.setOnClickListener {
            val uniqueid = username.text.toString()
            if (uniqueid.isNotEmpty()) {
                readData(uniqueid)
            } else{
                Toast.makeText(this,"Please enter user name", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun readData(uniqueid : String){
        databaseReference= FirebaseDatabase.getInstance().getReference("user")
        databaseReference.child(uniqueid).get().addOnSuccessListener {
if (it.exists()){
    val email= it.child("email").value
    val name= it.child("name").value

    val pass= it.child("password").value

    val intentfinal2= Intent(this, final2::class.java)
    intentfinal2.putExtra(KEY1, name.toString())
    intentfinal2.putExtra(KEY2, email.toString())
    intentfinal2.putExtra(KEY4, pass.toString())
    startActivity(intentfinal2)
}else{
    Toast.makeText(this,"User does not exist",Toast.LENGTH_SHORT).show()
}
        }.addOnFailureListener {
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
}