package com.example.filebase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clear.setOnClickListener {
            pai.setText("")
            pai1.setText("")
        }
        send.setOnClickListener {
            val firstn = pai.text.toString()
            val lastn = pai1.text.toString()
            val firebase = FirebaseDatabase.getInstance()
            val ref = firebase.getReference("Employee")
            val id:String? = ref.push().key
            val Employee = Employee(id.toString(),firstn,lastn)
            ref.child(id.toString()).setValue(Employee).addOnCompleteListener{
                Toast.makeText(applicationContext,"Complete",Toast.LENGTH_LONG).show()
                pai.setText("")
                pai1.setText("")
            }
        }

    }
}

