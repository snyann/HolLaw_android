package com.example.community.Activity

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import android.os.Bundle
import com.example.community.R
import android.content.Intent
import android.widget.Button
import android.widget.EditText
/*
class WriteActivity : AppCompatActivity() {
    private var database: FirebaseDatabase? = null
    private var databaseReference: DatabaseReference? = null
    var ID: String? = null

    inner class Write(var id: String, var title: String, var content: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_writing)

        val intent = intent
        ID = intent.getStringExtra("ID")
        val btn_complete = findViewById<Button>(R.id.btn_complete)
        btn_complete.setOnClickListener {
            val text_title = findViewById<EditText>(R.id.et_title)
            val text_content = findViewById<EditText>(R.id.et_content)
            val w: Write = Write( ID, text_title.text.toString(), text_content.text.toString())
            database = FirebaseDatabase.getInstance()
            databaseReference = database!!.reference
            databaseReference!!.child("게시판").child(ID!!).setValue(w)
            finish()
        }
    }
}*/