package com.example.k1

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var username:TextInputEditText
    lateinit var  password:TextInputEditText
    lateinit var btn:MaterialButton


    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        username=findViewById(R.id.user_box)
        password=findViewById(R.id.password_box)
        btn=findViewById(R.id.Submit)

        firebaseDatabase=FirebaseDatabase.getInstance()
        databaseReference=firebaseDatabase.getReference().child("User")

        btn.setOnClickListener {

            firebaseAuth=FirebaseAuth.getInstance()

            val email:String=username.text.toString().trim()
            val psw:String=password.text.toString().trim()



            firebaseAuth.createUserWithEmailAndPassword(email,psw).addOnSuccessListener {
                Toast.makeText(this@MainActivity,"User Registered ",Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity,"Error Occurred ",Toast.LENGTH_LONG).show()

            }




        }



    }
}